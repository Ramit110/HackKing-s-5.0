using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class GenerateMainMenu : MonoBehaviour {
    public List<Button> buttons;

    // Use this for initialization
    void Start () {
        buttons[0].onClick.AddListener(playClicked());
	}
	
	// Update is called once per frame
	void Update () {

    }

    private void playClicked()
    {

    }

    private void settingsClicked()
    {

    }

    private void exitClicked()
    {
        Application.Quit();
    }
}
