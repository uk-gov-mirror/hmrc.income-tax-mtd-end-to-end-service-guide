---
title: ITSA end-to-end service guide
weight: 1
description: Software developers, designers, product owners or business analysts. Integrate your software with the Income Tax API for Making Tax Digital.
---

# Income Tax Self Assessment end-to-end service guide

Version 1.3 issued 14 September 2020
***

This service guide is to help software designers and vendors understand how their software fits in with HMRC APIs.
It covers elements of the service delivered by HMRC to show how the Income Tax end-to-end service works.

Product owners, developers and business analysts can also use this guide to learn more about Making Tax Digital for Income Tax Self Assessment (ITSA).

## Overview

Making Tax Digital (MTD) for Income Tax is a service that will improve self-assessment for businesses and landlords that currently submit a tax return.

Similar to MTD for VAT, MTD for Income Tax requires businesses and landlords to keep their records digitally and to submit information about their business income to HMRC using MTD-compatible software.

The other major change is that businesses and landlords will no longer send an annual tax return. Instead, they will be required to send HMRC quarterly summary updates of their business income and expenditure as well as complete a process to finalise their overall tax position at the end of the year. 

Based on the information provided, they will receive a view of their emerging tax position, helping them to better budget for their tax throughout the year. There are no changes to payment dates.

Customers will be mandated to provide the following information through the software:

* income and expenses for each self-employment and property businesses at least every 3 months
* allowances and adjustments for each self-employment and property business at least once a year, at the end of the accounting period
* finalisation of business income sources with an End of Period Statement (EOPS)

HMRC expects software providers to offer customers the ability to finalise their overall tax position using the software. This process is sometimes called crystallisation.

In the future, partnerships will be required to provide the information mentioned above for the partnership. Individual partners will not be mandated to report their partner income quarterly.

HMRC will provide the APIs for the software to support all of the personal data items that need to be submitted under Self Assessment. Although these elements will not be mandated through the software, there will be market demand for software that enables any user to finalise the entirety of their tax affairs.

By developing a product now, you will support mandate of the service, influence its design and ensure you have a product ready for the millions of customers that will need MTD-compatible software.

## Software vendor overview

### Developer journey to production credentials

It is important that quality software products are available for customers to submit their self-assessment returns through Making Tax Digital. HMRC is committed to providing help and support for vendors and developers throughout the software development process.

Here, we describe the steps developers go through from initially registering an application to gaining production credentials to submitting live data and also the support available at each stage and the interactions developers will have with HMRC.

1.	Sign in to the [developer hub](https://developer.service.hmrc.gov.uk/api-documentation) and register your application for sandbox testing.
2.	Review the API documentation and Income Tax end-to-end service guide.
3.	Test ITSA endpoints and develop your software application, any queries during this phase should be sent to <SDSTeam@hmrc.gov.uk>.
4.	Register your application for production credentials by creating a production application within your developer hub account and completing the requested sections.
5.	Testing document is sent to the developer by email.
6.	Provide testing logs and credentials used for testing to HMRC.
7.	Developer testing is reviewed by HMRC (including fraud header validity).  If testing is satisfactory an email questionnaire and request for product demonstration are sent. Otherwise, further testing and development will be required for review.
8.	The software vendor demonstrates its software to HMRC over online screen sharing.
9.	Production credentials are issued if all requirements are met or further development is required and a new demonstration needs to be organised.
10.	Software is listed on GOV.UK after going through the HMRC recognition process.

## Production approvals process for Making Tax Digital for Self Assessment

### Testing requirements

The following endpoints are required to be tested to cover the self-employment reporting:

1. ‘Create a test user which is an organisation’ to create test data.
2. ‘Add a self-employment business’ endpoint to create an MTD subscription for an individual within the sandbox environment.
3. ‘Retrieve self-employment business obligations’ to return obligation periods (this will return a canned response the sandbox).
4. ‘Create a self-employment periodic update’ to make a submission.
5. ‘Amend a self-employment periodic update’ to amend a submission already made.
6. ‘Amend an self-employment annual summary’ to create or amend annual summary information.
7. ‘Trigger a calculation’ to request a calculation.
8. ‘Retrieve a calculation’ to return the calculation liability (this will return a canned response the sandbox).

The following endpoints are to be tested to cover EOPS (End of Period Statement) and Crystallisation:

1. ‘Submit self-employment End of Period Statement’ to finalise your self-employment income.
2. ‘Retrieve End of Period Statement Obligations for a Self-Employment Business’ to check if an EOPS obligation has been fulfilled, this will return a canned response in the sandbox.
3. ‘Intent to crystallise’ to return the tax Calculation ID for crystallisation.
4. ‘Retrieve a calculation’ with the tax Calculation ID for crystallisation, to return the calculation liability.  This will return a canned response in the sandbox.
5. ‘Crystallisation’ to finalise the tax liability.

Once the testing is complete, send details of the dummy NINO (National Insurance Number) used to call the above endpoints in the sandbox to the SDS team at <SDSTeam@hmrc.gsi.gov.uk>. 

You will need to contact us within 2 weeks of completing your API testing to enable us to view the data within our logs. 
It takes 10 working days to advise of the outcome. If the testing is satisfactory a product demonstration will be arranged.

Developers need to consider the following:

* build EOPs and crystallisation declarations within the software

* trigger the tax calculation after submitting an update that covers a full quarterly period as part of the software journey to meet the obligation

* consider the one-hour delay as part of the software workflow to update the status of obligations

* consider a 5 second delay before retrieving the calculation

* consider developing guidelines within the software for relevant users, including a reference to HMRC user interface journeys for individuals and agents

* use APIs as efficiently as possible to prevent hitting the rate limit

* build relevant error responses so that the software can deal with exceptions

* when authorising software, the correct MTD gateway credentials or agent services credentials, need to be used when logging into the system

* consider providing notifications to customers when periodic submissions are due

* build functionality to handle adjustments, losses or any further endpoints released in the future

### Fraud Prevention Headers

Transaction Monitoring (TxM) is a key security approach adopted in the UK and globally.

Supplying header information for all our APIs will become mandatory. We recommend designing it into your applications now before approval can be granted, and production credentials issued.   HMRC must see evidence of fraud prevention headers being sent.

The developer must test their fraud headers to derive the correct values and provide SDST with a screenshot of the response received from the Test Fraud Header API. [Guidance on Fraud Prevention Headers](https://developer.service.hmrc.gov.uk/api-documentation/docs/fraud-prevention) is available.

#### Example workflows for self-employment

1. Create an update. </br>
a. List all self-employment businesses.</br>
b. Create a self-employment periodic update.</br>
c. Trigger a tax calculation - can be triggered anytime but must be triggered at the end of the quarter to
meet the obligation.

2. Amend an update. </br>
a. List all self-employment update periods.</br>
b. Amend a self-employment periodic update.

3. End of Period Statement.</br>
a. Get a self-employment annual summary.</br>
b. Amend a self-employment annual summary.</br>
c. Get self-employment Business Income Summary Source (BISS).</br>
d. Retrieve end of period statement obligations for a self-employment business.</br>
e. Agree with the declaration within the software.</br>
f. Submit self-employment end of period statement.</br>

4. Crystallisation.</br>
a. Intent to crystallise.</br>
b. Retrieve a tax calculation - to view the current calculation.</br>
c. Agree with the declaration within the software.</br>
d. Crystallisation - agree on the final calculation.</br>

### Product Demonstration

The product demonstration is the final part of the process after all preceding steps have been completed. Make sure you have completed the <a href="documentation/mtd-itsa-sa-demo-checklist-self-serve.docx" download>pre-demo checklist</a> before the demonstration.

At the product demonstration HMRC expects to see a consumer-ready product and see software go through the following process flows:

1. New customer registers with the software and sets up an account.
2. Customer authorises software (OAuth 2.0 journey).
3. Customer views obligations and his or her status.
4. Customer digitally imports data into the appropriate periodic update and submits information.
5. Software triggers a calculation and replays to customer.
6. End of Period Statement (EOPs) and declaration.
7. Customer crystallisation - the appropriate display of the tax calculation, declarations, and error messages.

## Terms of use

Your application must comply with our [terms of use](https://developer.service.hmrc.gov.uk/api-documentation/docs/terms-of-use). You must accept the terms of use before we issue your application's production credentials.

## Software choices

HMRC publishes a [list of compatible software](https://www.gov.uk/government/publications/making-tax-digital-software-suppliers-terms-of-collaboration/terms-of-collaboration-between-hm-revenue-and-customs-and-software-developers#Annex-C) for Making Tax Digital for Income Tax on GOV.UK. Software vendors will be added to this list when they have completed the necessary steps in the ‘Software vendor overview’ section.  

From our experience with MTD VAT, businesses, agents and third parties will use this as the definitive list of MTD compatible software. All software listed on the GOV.UK page must allow the user to submit a summary of business or property information up to and including the End of Period Statement, and also offer users the ability to finalise their tax affairs using the software. The current GOV.UK page will be developed over time to meet user needs, including filters that help users to find software.

HMRC expects demand for products that serve all of the requirements of MTD, including keeping the required digital records for business or property income and the ability to submit all relevant non-business information to HMRC. 

HMRC has committed to the [availability of free software](https://www.gov.uk/government/publications/making-tax-digital-software-suppliers-terms-of-collaboration/terms-of-collaboration-between-hm-revenue-and-customs-and-software-developers#Annex-C) for small businesses.

## End-to-end user journey

These journeys show examples of use:

* [Income Tax Self Assessment (ITSA) set up activities](https://developer.service.hmrc.gov.uk/guides/income-tax-mtd-end-to-end-service-guide/documentation/setup.html)
* [retrieving obligations](https://developer.service.hmrc.gov.uk/guides/income-tax-mtd-end-to-end-service-guide/documentation/businessandpropertyincome.html#receive-obligations) 
* [submitting periodic updates for Self Employment and property businesses](https://developer.service.hmrc.gov.uk/guides/income-tax-mtd-end-to-end-service-guide/documentation/businessandpropertyincome.html#submit-periodic-updates-for-self-employment-and-property-businesses)
* [submitting annual updates for Self Employment and property businesses](https://developer.service.hmrc.gov.uk/guides/income-tax-mtd-end-to-end-service-guide/documentation/businessandpropertyincome.html#submit-annual-updates-for-se-and-property-businesses)
* [retrieving a tax calculations](https://developer.service.hmrc.gov.uk/guides/income-tax-mtd-end-to-end-service-guide/documentation/businessandpropertyincome.html#retrieve-a-tax-calculation)
* [making changes to previously submitted data](https://developer.service.hmrc.gov.uk/guides/income-tax-mtd-end-to-end-service-guide/documentation/businessandpropertyincome.html#make-changes-to-previously-submitted-data)
* [finalising business income End of Period Statement (EOPS)](https://developer.service.hmrc.gov.uk/guides/income-tax-mtd-end-to-end-service-guide/documentation/businessandpropertyincome.html#finalise-business-income-end-of-period-statement-eops)
* [providing information about how to treat a loss](https://developer.service.hmrc.gov.uk/guides/income-tax-mtd-end-to-end-service-guide/documentation/final-return-crystallisation.html#provide-information-about-how-to-treat-a-loss)
* [crystallisation](https://developer.service.hmrc.gov.uk/guides/income-tax-mtd-end-to-end-service-guide/documentation/final-return-crystallisation.html#crystallisation)
* [ITSA (MTD) close down activities](https://developer.service.hmrc.gov.uk/guides/income-tax-mtd-end-to-end-service-guide/documentation/closedown.html)

## Related API documentation
<!--- Section owner: MTD Programme --->
* [Create Test User API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/api-platform-test-user/1.0)
* [Test Fraud Prevention Headers API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/txm-fph-validator-api/1.0)
* [Agent Authorisation REST API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/agent-authorisation-api/1.0)

## Changelog

Version 1.1

* Payments and Liabilities section added.

Version 1.2

* Multiple businesses section added.
* Construction Industry Scheme (CIS) section added.

Verison 1.3

* Losses updated.
* Additional income section added.

