![email](/assets/springbootEmail.png)
# Mail Service

This is a simple Spring Boot project that shows how to send an email. In this example we use google mail.

### Configuration

You have to edit __*application.properties*__ and change the google's emails attributes.

Before start to use you have to create an app password (__your google's mail password will not work__). [Here](https://support.google.com/accounts/answer/185833) you have all details how to do.

### Test

<pre><code>
curl --location '127.0.0.1:8080/send' \
--header 'Content-Type: application/json' \
--data-raw '{
"from":"your_email@gmail.com",
"to":"destination_email@xyz",
"subject":"Test",
"text":"This is a test"
}'
</code></pre>