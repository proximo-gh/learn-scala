package ru.proximo

import _root_.com.vaadin.server.VaadinRequest
import _root_.com.vaadin.ui.{Label, Button, VerticalLayout, UI}

/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 1/25/13
 * Time: 11:40 PM
 */
class ChatUI extends UI {

  def init(p1: VaadinRequest) {
    val layout: VerticalLayout = new VerticalLayout
    layout.setMargin(true)

    setContent(layout)

    val button: Button = new Button("Click Me")

    button.addClickListener(new Button.ClickListener {
      def buttonClick(event: Button.ClickEvent) {
        layout.addComponent(new Label("Thank you for clicking"))
      }
    })

    layout.addComponent(button)
  }
}
