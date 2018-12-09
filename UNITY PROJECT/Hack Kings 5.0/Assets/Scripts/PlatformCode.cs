using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class PlatformCode : MonoBehaviour {

    [HideInInspector] public bool facingRight = true;
    [HideInInspector] public bool jump = false;

    public float moveSpeed;
    public float jumpForce;
    public List<GameObject> otherItems;

    public Transform groundCheck;
    public GameObject parent;

    private Animator anim;
    private Rigidbody2D rb2d;
    private BoxCollider2D bc2d;
    private SpriteRenderer sr;

    private Vector2 initialPosition;

    private int lives = 3;
    public GameObject[] lifeLeft;

    public Button kill;

    // Use this for initialization
    void Start () {
        anim = GetComponent<Animator>();
        rb2d = GetComponent<Rigidbody2D>();
        bc2d = GetComponent<BoxCollider2D>();
        sr = GetComponent<SpriteRenderer>();

        initialPosition = GetComponent<Renderer>().bounds.center;

        parent.SetActive(false);
        kill.onClick.AddListener(escape);
    }
	
	// Update is called once per frame
	void Update () {
        bool grounded = Physics2D.Linecast(transform.position, groundCheck.position, 
            1 << LayerMask.NameToLayer("Ground"));

        foreach (GameObject items in otherItems)
        {
            if (Input.GetButtonDown("Vertical") && bc2d.IsTouching(items.GetComponent<Collider2D>()))
            {
                jump = true;
            }
        }
    }

    void FixedUpdate()
    {
        float h = Input.GetAxis("Horizontal");
        float ability = Input.GetAxis("ability");

        if (h != 0)
        {
            rb2d.velocity = new Vector2(h * moveSpeed, 
                rb2d.velocity.y);
            anim.enabled = true;
        }
        else
        {
            rb2d.velocity = new Vector2(0f, rb2d.velocity.y);
            anim.enabled = false;
        }

        if(ability != 0)
        {
            bc2d.enabled = false;
            sr.enabled = false;
        }
        else
        {
            bc2d.enabled = true;
            sr.enabled = true;
        }

        if (h > 0 && !facingRight)
            Flip();
        else if (h < 0 && facingRight)
            Flip();

        if (jump)
        {
            // anim.SetTrigger("Jump");
            rb2d.AddForce(new Vector2(0f, jumpForce));
            jump = false;
        }

        checkDead();
    }

    public void playerDied()
    {
        Debug.Log(":: ::");
        lives -= 1;
        if (lives > 0)
        {
            lifeLeft[lives].SetActive(false);
        }
        if (lives == 0)
        {
            parent.SetActive(true);
        }
        transform.position = initialPosition;
    }

    void checkDead()
    {
        foreach(GameObject items in otherItems)
        {
            if(bc2d.Distance(items.GetComponent<BoxCollider2D>()).distance < -5 )
            {
                playerDied();
            }
        }
    }

    void Flip()
    {
        facingRight = !facingRight;
        Vector3 theScale = transform.localScale;
        theScale.x *= -1;
        transform.localScale = theScale;
    }

    public void escape()
    {
        SceneManager.LoadScene("MainMenu");
    }
}
