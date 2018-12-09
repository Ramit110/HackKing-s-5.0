using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class CreateLevelSelect : MonoBehaviour {
    public List<Button> levelSelect;
    public Button leave;

	// Use this for initialization
	void Start () {
        levelSelect[0].onClick.AddListener(delegate { loadLevel(0); });
        leave.onClick.AddListener(leaveClicked);
	}
	
	// Update is called once per frame
	void Update () {
		
	}

    private void leaveClicked()
    {
        SceneManager.LoadScene("MainMenu");
    }

    private void loadLevel(int level)
    {
        SceneManager.LoadScene("Level-"+level);
    }
}
