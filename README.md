# IVR Flow for Jio

This repository contains my internship project focused on designing and building an **Interactive Voice Response (IVR)** system for **Jio customer services** using AWS technologies.

---

## 📋 Project Overview

The IVR system allows Jio users to interact with a voice menu to access services such as:

- Checking data balance
- Viewing plans and offers
- Knowing the nearest Jio service center
- Speaking to a customer care executive

The call flow is designed using **Amazon Connect**, with backend processing handled by **AWS Lambda**, and customer data retrieved from **DynamoDB**.

---

## 🔄 IVR Flow Summary

1. User dials the IVR number
2. The system plays a welcome message
3. User selects an option:
   - 1️⃣ Data Balance
   - 2️⃣ Plans and offers
   - 3️⃣ Nearest Store
   - 4️⃣ Talk to Executive
4. Lambda function is triggered to:
   - Fetch user data from DynamoDB
   - Provide an appropriate response
5. Call continues based on input or is transferred to a live agent

---

## 🖼️ Call Flow Diagram

![IVR Flow](./connect-flows/screenshots/ivr-flow-diagram.png)

> This image illustrates the actual call flow as designed in Amazon Connect.

---

## 📤 Importing the IVR Flow

To test or reuse this IVR design in your own Amazon Connect instance:

1. Go to **Amazon Connect → Contact Flows**
2. Click **“Create contact flow”**
3. Select the **“Import flow (JSON)”** option
4. Upload the file: `connect-flows/jio-ivr-flow.json` from this repository
5. Click **“Save”** and then **“Publish”**

> 💡 Make sure your AWS Connect instance is properly set up with access to Lambda and DynamoDB if those are referenced in your flow.

---

## 🧑‍💼 Author

**Varsha A R**  
Internship Project for Jio  
[LinkedIn Profile](https://www.linkedin.com/in/varsha-ar-022658292?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app )

---

## 📄 Disclaimer

This project is created for learning and demonstration purposes only.  
No real customer data is used or shared.

---
