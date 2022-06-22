Ofek Avergil 
Hod Amar 

You will need to download this:
server side:
- mariaDB
- Microsoft.AspNet.SignalR
- Microsoft.EntityFramework
- Pomelo.EntityFramework
client side:
    "@microsoft/signalr": "^6.0.5",
    "@testing-library/jest-dom": "^5.16.4",
    "@testing-library/react": "^13.1.1",
    "@testing-library/user-event": "^13.5.0",
    "react": "^18.1.0",
    "react-dom": "^18.0.0",
    "react-live-clock": "^5.8.2",
    "react-perfect-scrollbar": "^1.5.8",
    "react-router-dom": "^6.3.0",
    "react-scripts": "^5.0.1",
    "web-vitals": "^2.1.4"

How to run it:
- [run WebChatServer project](https://github.com/hodamarr/SeverEx2.git)
    - the address should be localhost:7149
- [run ChatAPP_android project from this repository]
- [run webChat_client from](https://github.com/hodamarr/WebChat_Client.git)
    - the adress should be localhost:3000

How to play in ChatAPP_android:
- Sign Up user:
    you can  sign in with new user, notice those limitions: 
    1. Username consists of alphanumeric characters (a-zA-Z0-9), lowercase, or uppercase.
    Username allowed of the dot (.), underscore (), and hyphen (-).
    The dot (.), underscore (), or hyphen (-) must not be the first or last character.
    The dot (.), underscore (_), or hyphen (-) does not appear consecutively, e.g., java..regex
    The number of characters must be between 5 to 20
    2. password should contain 8 chars, at least one letter and one number.
    3. nick max size is 10 letters
    4. server should be "localhost:7149" to work with our server. 
    
-Add contacts:
    1. On the main page click on "new"
    2. Enter id name as you like
    3. Enter a registered user name
    4. Enter the user's server . for example: "localhost:7777"
    5. click done. now you can message your contact.
    
-Change default server:
    on the contacts page there is the settings button. you can click and in the open window type a valid server address. if you choose to change it you will exit to the main window, and need to log in with compitable user. we check if the user is on the same server.

enjoy!
