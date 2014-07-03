package com.codenvy.example.jython;

import org.python.core.Py;
import org.python.core.PySystemState;
import org.python.util.InteractiveConsole;

import java.util.Properties;

public class Application {

    private final InteractiveConsole jyConsole;

    public Application(String... args) {
        PySystemState.initialize(PySystemState.getBaseProperties(), new Properties(), args);

        jyConsole = new InteractiveConsole();

        Py.getSystemState().__setattr__("_jy_interpreter", Py.java2py(jyConsole));
    }

    public static void main(String... args) {
        new Application(args).run();
    }

    public void run() {
        jyConsole.execfile(ClassLoader.getSystemResourceAsStream("__init__.py"));
    }
}
