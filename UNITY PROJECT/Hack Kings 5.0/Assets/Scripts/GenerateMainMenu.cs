using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class GenerateMainMenu : MonoBehaviour {
    public List<Button> buttons;
    public GameObject SettingsMenu;

    // Use this for initialization
    void Start ()
    {
        buttons[0].onClick.AddListener(playClicked);
        buttons[1].onClick.AddListener(settingsClicked);
        buttons[2].onClick.AddListener(exitClicked);
        buttons[3].onClick.AddListener(settingsCloseClicked);

        SettingsMenu.SetActive(false);
    }
	
	// Update is called once per frame
	void Update () {

    }

    private void playClicked()
    {
        SceneManager.LoadScene("LevelSelect");
    }

    private void settingsClicked()
    {
        SettingsMenu.SetActive(true);
    }

    private void settingsCloseClicked()
    {
        SettingsMenu.SetActive(false);
    }

    private void exitClicked()
    {
        Application.Quit();
    }
}
