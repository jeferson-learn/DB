package com.automationpractice.framework.widgets;

import org.openqa.selenium.Keys;

public interface ITextField {
    ITextField setText (String text);
    ITextField setKeys (Keys keys);
}
