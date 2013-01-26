package ru.proximo

import _root_.com.vaadin.data.fieldgroup.FieldGroup
import _root_.com.vaadin.data.validator.StringLengthValidator
import com.vaadin.server.VaadinRequest
import _root_.com.vaadin.ui._
import schat.{User, Room}

/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 1/25/13
 * Time: 11:40 PM
 */
class ChatUI extends UI {

  val room = new Room

  lazy val roomList = new ListSelect("Users")

  def init(p1: VaadinRequest) {
    val layout: VerticalLayout = new VerticalLayout
    layout.setMargin(true)

    setContent(layout)

    layout addComponent createAddUserForm
    layout addComponent roomList
  }

  def createAddUserForm() : Component = {
    val layout = new VerticalLayout

    val userNameField = new TextField("Username", "")

    userNameField addValidator(new StringLengthValidator("Username must have at least one letter", 1, 1000, false))

    layout addComponent userNameField

    val button: Button = new Button("Add user")

    button.addClickListener(new Button.ClickListener {
      def buttonClick(event: Button.ClickEvent) {
        val userName = userNameField.getValue

        room addUser new User(userName)

        paintRoom()
      }
    })

    layout.addComponent(button)

    layout
  }

  def paintRoom() : Unit = {
    roomList removeAllItems()

    room.getUsers.foreach((user: User) => {
      roomList.addItem(user)
      roomList.setItemCaption(user, user.getName)
    })
  }
}
