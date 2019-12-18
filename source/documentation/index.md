---
title: ITSA end-to-end service guide
weight: 1
description: Software developers, designers, product owners or business analysts. Integrate your software with the Income Tax API for Making Tax Digital.
---

# Income Tax Self Assessment end-to-end service guide

Version 1.0 issued XX December 2019
***

This service guide is to help software designers and vendors understand how their software fits in with HMRC APIs.
It covers elements of the service delivered by HMRC to show how the Income Tax end-to-end service works.

Product owners, developers and business analysts can also use this guide to learn more about Making Tax Digital for Income Tax Self Assessment (ITSA).

## Overview

Making Tax Digital (MTD) for Income Tax is a service that will improve Self Assessment for the 7 million businesses that currently submit a tax return.

Like MTD for VAT, MTD for Income Tax requires businesses and landlords to keep their records digitally and submit information about business income to HMRC using MTD-compatible software. 

The other major change is that businesses and landlords will no longer send an annual tax return. Instead, they will be required to send HMRC quarterly summary updates of their business income and expenditure, and complete a process to finalise their overall tax position at the end of the year. They will receive a view of their emerging tax position based on the information provided, helping them budget for their tax better throughout the year. There are no changes to payment dates.

Customers will be mandated to provide the following information through software:

* income and expenses for each self-employment and property businesses at least every 3 months
* allowances and adjustments for each self-employment and property business at least once a year, at the end of the accounting period
* finalisation of business income sources with an End of Period Statement (EPS)

HMRC expects all software providers to also offer customers the ability to finalise their overall tax  position using software. This process is sometimes called crystallisation.

In the future, partnerships will be required to provide the information mentioned above for the partnership. Individual partners will not be mandated to report their partner income quarterly.

HMRC are also providing the APIs for software to support all of the personal data items that need to be submitted under Self Assessment. Although these elements will not be mandated through software, there will be demand for software that enables any user to finalise the entirety of their tax affairs.

By developing a product now, you will support mandation of the service, influence its design and ensure you have a product ready for the millions of business and agents that will need MTD compatible software.

## Software vendor overview

### Developer journey to production credentials

It is important that quality software products are available for customers to submit their self-assessment returns through Making Tax Digital. HMRC is committed to providing help and support for vendors and developers throughout the software development process.

Here, we describe the steps developers go through from initially registering an application to gaining production credentials to submitting live data and also the support available at each stage and the interactions developers will have with HMRC.

1.	Sign into developer hub and register your application for sandbox. testing. (https://developer.service.hmrc.gov.uk/api-documentation)
2.	Review the API documentation and Income Tax end-to-end service guide.
3.	Test ITSA endpoints and develop software application, any queries during this phase should be sent to SDSTeam@hmrc.gov.uk.
4.	Register your application for production credentials by creating a production application within your developer hub account and complete the requested sections.
5.	Testing document sent to the developer by email (Appendix 1).
6.	Provide testing logs and credentials used for testing to HMRC.
7.	Developer testing is reviewed by HMRC (including fraud header validity).  If testing is satisfactory an email questionnaire (Appendix 2) and request for product demonstration is sent, otherwise further testing and development will be required for review.
8.	Software vendor demonstrates their software to HMRC over online screen sharing.
9.	Production credentials are issued if all requirements are met or further development required and new demonstration needs to be organised.
10.	Software is listed on Find software for Making Tax Digital for VAT GOV.UK page for VAT after going through the HMRC recognition process.

## Production approvals process for Making Tax Digital for SA

### Testing requirements

The following endpoints are required to be tested to cover the Self-employment reporting:

1. ‘Create a test user which is an organisation’ to create test data.
2. ‘Add a self-employment business’ endpoint to create an MTD subscription for an individual within the sandbox environment.
3. ‘Retrieve self-employment business obligations’ to return obligation periods (This will return a canned response in sandbox).
4. ‘Create a self-employment periodic update’ to make a submission.
5. ‘amend a self-employment periodic update’ to amend a submission already made.
6. ‘Amend a self-employment annual summary’ to create or amend annual summary information.
7. ‘Trigger a calculation’ to request a calculation.
8. ‘Retrieve a calculation’ to return the calculation liability (this will return a canned response in sandbox).

The following endpoints are to be tested to cover EOPS (End of Period Statement) and Crystallisation:

1. ‘Submit self-employment End-of-Period Statement’ to finalise your self-employment income
2. ‘Retrieve End of Period Statement Obligations for a Self-Employment Business’ to check if an EOPS obligation has been fulfilled, this will return a canned response in sandbox.
3. ‘Intent to crystallise’ to return the tax Calculation ID for crystallisation.
4. ‘Retrieve a calculation’ with the tax Calculation ID for crystallisation, to return the calculation liability, this will return a canned response in sandbox.
5. ‘Crystallisation’ to finalise the tax liability.

Once the testing is complete, send details of the dummy NINO used to call the above endpoints in sandbox to SDS team at SDSTeam@hmrc.gsi.gov.uk. 

You will need to contact us within 2 weeks of completing your API testing to enable us to view the data within our logs. 
The current service level agreement for SDST checks is 10 working days to advise of the outcome. If testing is satisfactory a product demonstration will be arranged.

Developers need to consider the following:

* build EOPs and crystallisation declarations within the software

* trigger the tax calculation after submitting an update that covers a full quarterly period as part of the software journey to meet the obligation

* consider the one hour delay as part of the software workflow to update the status of obligations

* consider a 5 second delay before retrieving the calculation

* consider building guidance within the software for relevant users including reference to HMRC user interface journeys for individuals and agents

* use APIs as efficiently as possible to prevent hitting the rate limit

* build relevant error responses so that the software can deal with exceptions

* when authorising software, the correct MTD gateway credentialsor agent services credentials, need to be used when logging into the system

* consider providing notifications to customers when periodic submissions are due

* build functionality to handle adjustments, losses or any further endpoints released in the future

### Fraud Prevention Headers

Transaction Monitoring (TxM) is a key security approach adopted in the UK and globally.

Supplying header information for all our APIs will become mandatory, we recommend designing it into your applications now before approval can be granted, and production credentials issued HMRC must see evidence of fraud prevention headers being sent.

The developer must test their fraud headers to derive the correct values and provide SDST with a screenshot of the response received from the Test Fraud Header API. Guidance on Fraud Prevention Headers can be found here.

#### Example workflows for Self-employment

1. Create an update.
a. List all self-employment businesses.
b. Create a self-employment periodic update.
c. Trigger a tax calculation (can be triggered anytime but must be triggered at the end of the quarter to
meet the obligation).

2. Amend an update.
a. List all self-employment update periods.
b. Amend a self-employment periodic update.

3. End of Period Statement.
a. Get a self-employment annual summary.
b. Amend a self-employment annual summary.
c. Get self-employment Business Income Summary Source (BISS).
d. Retrieve end of period statement obligations for a self-employment business.
e. Agree the declaration - within software.
f. Submit self-employment end of period statement.

4. Crystallisation.
a. Intent to crystallise.
b. Retrieve a tax calculation - to view the current calculation.
c. Agree the declaration - within software.
d. Crystallisation - agree the final calculation.

### Product Demonstration

The product demonstration is the final part of the process after all preceding steps have been completed.

At the product demonstration HMRC will be expecting to see a market ready product and will wish to see software
run through the following process flows:

1. New customer registers with the software and set up an account.
2. Customer authorises software (the OAuth 2.0 journey).
3. Customer views obligations and their status.
4. Customer digitally imports data into the appropriate periodic update and submits.
5. Software triggers a calculation and replays to customer.
6. End of Period Statement (EOPs) and declaration.
7. Customer crystallisation - appropriate display of the tax calculation, declarations, and error messages.

## Terms of use

Your application must comply with our [terms of use](https://developer.service.hmrc.gov.uk/api-documentation/docs/terms-of-use). You must accept the terms of use before we issue your applications production credentials.

## Software choices

HMRC publishes a [list of compatible software](https://www.gov.uk/government/publications/making-tax-digital-software-suppliers-terms-of-collaboration/terms-of-collaboration-between-hm-revenue-and-customs-and-software-developers#Annex-C) for Making Tax Digital for Income Tax on GOV.UK. Software vendors will be added to this list when they have completed the necessary steps in the ‘Software vendor overview’ section.  

From our experience with MTD VAT, businesses, agents, and third parties will use this as the definitive list of MTD compatible software. All software listed on the page must allow the user to submit a summary of business or property information up to and including the End of Period Statement, and also offer users the ability to finalise their tax affairs using software.  The current page will be developed over time to meet user needs, including filters that help users to find software.

HMRC expects demand for products that serve all of the requirements of MTD, including keeping the required digital records for business or property income and the ability to submit all relevant non-business information to HMRC. 

HMRC has committed to the [availability of free software](https://www.gov.uk/government/publications/making-tax-digital-software-suppliers-terms-of-collaboration/terms-of-collaboration-between-hm-revenue-and-customs-and-software-developers#Annex-C) for small businesses.

## End-to-end user journey

ADD LINKS TO CONTENT WHEN AVAILABLE

## Related API documentation
<!--- Section owner: MTD Programme --->
* [Income Tax (MTD) REST API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api?filter=income-tax)
* [Individual Calculations (MTD)	REST API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0)
* [Individual Losses (MTD)	REST API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-losses-api/1.0)
* [Self Assessment (MTD)](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/self-assessment-api/2.0)
* [Create Test User API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/api-platform-test-user/1.0)
* [Agent Authorisation	REST API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/agent-authorisation-api/1.0)
* [Test Fraud Prevention Headers API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/txm-fph-validator-api/1.0)
