---
title: HMRC online services
weight: 9
description: Sign in to HMRC online services to manage your income tax.
---

<!--- Section owner: MTD Programme --->

# HMRC online services
Self-assessment customers who have signed up for Making Tax Digital for Income Tax can [sign into HMRC online services](https://www.gov.uk/log-in-register-hmrc-online-services) to access relevant services. Customers can reach their Making Tax Digital account by clicking the **Making Tax Digital for Income Tax** link.

Software providers need to design a customer journey between software and HMRC online services. Whenever the journey takes the customer to HMRC online services, the service should open in a new browser window. This will allow customers to complete additional tasks not available in the software.

The following table lists the tasks customers will be able to complete through HMRC online services and/or third-party software:

| Task                                                                                                                                                             | Status             | HMRC online services | Software |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------ | -------------------- | -------- |
| [Change contact preference between paper and digital secure messages](#changing-contact-preference-between-paper-and-digital-secure-messages)                                                                                        | Live               | Yes                  | No       |
| Change business details                                                                                                                                    | Future development | Yes                  | No       |
| Change the amount of a payment on account                                                                                                                        | Future development | Yes                  | No       |
| Check when updates and payments are due                                                                                                                    | Live               | Yes                  | Yes      |
| [Add new business details for a self-employment sole trader or property business](#adding-new-business-details-for-a-self-employment-sole-trader-or-property-business)                                                                                                                             | Under development  | Yes                  | No       |
| [Close (cease) a self-employment sole trader or property business](#closing-ceasing-a-self-employment-sole-trader-or-property-business)                                                                                               | Under development  | Yes                  | No       |
| Elect for calendar quarterly periods                                                                                                               | Future development | No                   | Yes      |
| Submit non-MTD income and allowance types required to complete a self assessment tax return                                                                                                                                | Live               | Yes                  | No       |
| View in-year, forecast, self assessment tax calculations                                                                                                         | Live               | Yes                  | Yes      |
| Print a Self Assessment SA302 tax calculation | Future development | Yes                  | Yes      |
| Check how much is owed through MTD                                                                                                                              | Live               | Yes                  | Yes      |
| Request a budget payment plan                                                                                                                                    | Future development | Yes                  | No       |
| Request a time to pay                                                                                                                                            | Future development | Yes                  | No       |
| [Make a payment](#making-a-payment)                                                                                                                                                   | Live               | Yes                  | No       |
| Check money in the account                                                                                                                                     | Live               | Yes                  | Yes      |
| [Claim a refund](#claiming-a-refund)                                                                                                                                                | Under development  | Yes                  | No       |
| Check refund details and status                                                                                                                               | Under development  | Yes                  | No       |
| Provide bank details for future refunds                                                                                                                                  | Future development | Yes                  | No       |
| Leave MTD as a voluntary customer                                                                                                                                | Future development | Yes                  | No       |

Agents will be able to access Making Tax Digital for Income Tax services through their agent services account. They will be able to access all current and future services on behalf of their clients including the services listed in the above table, except for:

- changing their client’s repayment bank details 
- changing their client’s contact preference

## Changing contact preference between paper and digital secure messages

To make MTD communication accessible to all customers, HMRC has provided them with a contact preference for paper or digital methods.  If customers have selected a digital preference, they will be able to view communications sent to them by HMRC through a secure mailbox accessible through HMRC online services.  HMRC encourages customers to sign up for digital messages as they will get reminders for when to make different updates and payments, which is not available through paper messages. 

## Adding new business details for a self-employment sole trader or property business

New self-employment and property businesses can be added using HMRC online services as soon as the business has started. Customers will have a grace period of up to 2 years before the business is included in MTD if the total qualifying income from all business income is over the MTD threshold.  If a customer adds the new business within the 2-year grace period, they can choose to bring it into MTD immediately and commence voluntary quarterly updates or can decide to keep it outside of MTD and submit the income annually after the year end as normal on their SA return.

After a new business is added, it can be seen almost immediately in software when the next API call is made to the [Business Details API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/business-details-api/). Customers can submit updates or an annual return for this new business on the same day.

Customers need to provide the following information to add a new business source:

**Self employment:**

- Start date.
- Business address.
- Nature of business.
- Business name.
- Accounting method – cash or traditional accounting. If the customer has more than one self employment source, they all must have the same accounting method.

**UK and Foreign property:**

- Start date
- Accounting method

## Closing (ceasing) a self-employment sole trader or property business

Self employment and property businesses can be ceased by entering the date the business ended using HMRC online services. However, when ceasing a property business, the customer needs to do this only when they no longer receive any type of rental income from all of their properties. Customers within MTD will be required to submit quarterly updates for the periods up to the date the business ended and any future quarterly obligations will be removed.

Customers must update HMRC online services with the cease date as soon as possible to avoid late penalties that could be raised against future quarterly obligations. 

After a business has been updated as ceased, it can be seen almost immediately in software when the next API call is made to the [Business Details API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/business-details-api/). Customers can submit updates or an annual return for this new business on the same day.

In the future, it will be possible to reopen a closed business or change an incorrectly entered end date.

## Making a Payment

Customers can make a payment towards their liability through HMRC online services or there is an alternative route which is detailed on [Pay your Self Assessment tax bill: Overview - GOV.UK (www.gov.uk)](https://www.gov.uk/pay-self-assessment-tax-bill?_ga=2.87410077.442895640.1693813671-569616403.1678098699&_gl=1*xnov4c*_ga*NTY5NjE2NDAzLjE2NzgwOTg2OTk.*_ga_Y4LWMWY6WS*MTY5NDAxMTU5Ny43LjEuMTY5NDAxMTYwOS4wLjAuMA..). 

When a payment is made, the current payment service will first check to see if there is any outstanding liability from previous Self Assessment Tax returns, and it will prioritise the allocation of funds there.  Following that allocation, if there is any payment remaining, it will be allocated to any unpaid Payment on account charges  or  owed liability following an MTD final declaration.  If those remaining funds don’t fully cover that MTD liability, this still must  be paid by 31st January.  In this instance, the [Self Assessment Accounts API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/self-assessment-accounts-api/) can be used through software to see how much of their MTD liability is outstanding. However, it will not show them the amount that has been apportioned to previous tax year self assessment returns.  To view this, a customer will need to access HMRC online services.   

## Claiming a refund

For current MTD customers, a refund must be claimed by contacting HMRC. Claiming a refund through HMRC online services is scheduled for future development and we will provide further information here when available. 

## Future development
The following tasks are scheduled for future development and we will provide more information on them when available:

- Change business details
- Change the amount of a payment on account
- Elect for calendar quarterly periods
- Print a Self Assessment SA302 tax calculation
- Request a budget payment plan
- Request a time to pay
- Check refund details and status
- Provide bank details for future repayments
- Leave MTD as a voluntary customer  - customers will also be able to sign up again from their account


