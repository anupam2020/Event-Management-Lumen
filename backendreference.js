// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later,
// measurementId is optional
var firebaseConfig = {
apiKey: "AIzaSyAv_PFCLcflPPO5NYtXkz5r-H9J2IEQzUQ",
authDomain: "login-demo-a03bf.firebaseapp.com",
projectId: "login-demo-a03bf",
storageBucket: "login-demo-a03bf.appspot.com",
messagingSenderId: "831896060677",
appId: "1:831896060677:web:a0616c95abc1bcdedf6d6c",
measurementId: "G-XWHF8K6XSV",
};

// Initialize Firebase
firebase.initializeApp(firebaseConfig);

const auth = firebase.auth();

// Signup function
function signUp() {
var email = document.getElementById("email");
var password = document.getElementById("password");

const promise = auth.createUserWithEmailAndPassword(
	email.value,
	password.value
);
promise.catch((e) => alert(e.message));
alert("SignUp Successfully");
}

// SignIN function
function signIn() {
var email = document.getElementById("email");
var password = document.getElementById("password");
const promise = auth.signInWithEmailAndPassword(
			email.value, password.value);
promise.catch((e) => alert(e.message));
}

// SignOut
function signOut() {
auth.signOut();
alert("SignOut Successfully from System");
}

// Active user to homepage
firebase.auth().onAuthStateChanged((user) => {
if (user) {
	var email = user.email;
	alert("Active user " + email);
} else {
	alert("No Active user Found");
}
});
