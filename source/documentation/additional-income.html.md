---
title: Additional income
weight: 30
description: Software developers, designers, product owners or business analysts. Integrate your software with the Income Tax API for Making Tax Digital.
---

# Additional income

## Employments

This suite of endpoints display the PAYE information returned to HMRC by a user’s employers.

The user will be able to add to or supply different employment data after the tax year has ended.  This can include details of missing employments, or financial data.  In addition, the user can choose to ignore the data HMRC holds, for the purpose of their self-assessment calculation.

These endpoints can be broken into three categories:

* details of the Employment  
* financial data and benefits from a specific employment
* employment expenses from all of the user’s employments

Add a custom employment
Amend a custom employment
Retrieve an employment
List employments
Delete a custom employment
Ignore employment

Amend employment financial details
Retrieve an employment and its financial details
Delete employment financial details

Amend employment expenses
Retrieve employment expenses
Delete employment expenses
Ignore employment expenses

[INSERT DIAGRAM]

HMRC will pre-populate the employment information provided by employers. The user should check and correct the information, as necessary, prior to Crystallisation. 

**Note:** 

Pre-populated data can only be stopped (ignored) from being used in any tax calculation.

User-generated content:

* can be deleted
* will only be applied in the tax calculation 
* will not overwrite pre-populated data

Custom employments will only apply to the tax year and will not be carried over in subsequent years.  The expenses values are summed values from all PAYE employments, they are not available by employment.


## Other Employment Income

These endpoints allow a user to retrieve other employment income: Share options, Shares awarded or received, Disability and Foreign service.

[INSERT DIAGRAM]

Retrieve other employment Income [test only]
Amend other employment Income [test only]
Delete other employment Income [test only]

## Dividends income

These endpoints allow a user to retrieve, amend and delete dividends income: foreign dividend, dividend income received whilst abroad, stock dividend, redeemable shares, bonus issues of securities and close company loans written off.

[INSERT DIAGRAM]

Retrieve dividends income [test only]
Amend dividends income [test only]
Delete dividends income [test only]

## Foreign income

These endpoints give the user the ability to manage their data related to foreign earnings and unremittable foreign income.

The user can submit details of their foreign earnings and foreign income for a specific tax year, as well as amend submissions already made.  They also have the option to delete previous submissions, and to retrieve the information they have previously submitted. 

The new functionality provides three endpoints, to submit or amend foreign earnings and foreign income, delete a submission, or retrieve details of a submission.

[INSERT DIAGRAM]

Amend foreign income
Delete foreign income
Retrieve foreign income

## Insurance policies income

These endpoints allow a user to retrieve, amend and delete insurance policies and income for less common types of income: Life Insurance Policies, Life Annuity Contracts, Capital Redemption Policies, Voided ISAs, Foreign Policies. A National Insurance number and tax year must be provided.

[INSERT DIAGRAM]

Retrieve Insurance Policies Income [test only]
Amend Insurance Policies Income [test only]
Delete Insurance Policies Income [test only]

## Pensions income

These endpoints allow a user to retrieve, amend and delete previously populated foreign pensions and overseas pension contributions.

[INSERT DIAGRAM]

Retrieve Pensions Income [test only]
Amend Pensions Income [test only]
Delete Pensions Income [test only]

## Other income

These endpoints allow a user to retrieve other income: business receipts, all other income received whilst abroad, overseas income and gains, chargeable foreign benefits and gifts and omitted foreign income.

[INSERT DIAGRAM]

Retrieve Other Income [test only]
Amend Other Income [test only]
Delete Other Income [test only]

### Savings income

These endpoints allow a user to retrieve, amend and delete savings income for securities or foreign interest. 

[INSERT DIAGRAM]


Retrieve Savings Income [test only]
Amend Savings Income [test only]
Delete Savings Income [test only]

#### Disclosures

This endpoint allows the user to manage their data related to the disclosure of tax avoidance schemes and undeclared income, for a given tax year. 

The user can submit details of any disclosures for a specific tax year, as well as amend submissions already made.  They also have the option to delete previous submissions, and to retrieve the information they have previously submitted. 

The new functionality provides three endpoints, to submit or amend disclosures, delete a submission, or retrieve details of a submission.

The user would normally call this when they have all the information necessary for disclosures for the tax year (and presumably, make any amendments prior to the crystallisation process).
[THIS THIS PARA IS CORRECT WITH - DSM]

* Amend disclosures
* Delete disclosures
* Retrieve disclosures


#### Pension charges

These endpoints allow a user to manage data related to pension contributions and charges. The user can submit details of pension contributions and charges for a specific tax year, as well as amend submissions already made. The user also has the option to delete previous submissions, and to retrieve the information they have previously submitted.
 
The new functionality provides three new endpoints: amend new pension charges, delete a submission, and retrieve details of a submission.

[INSERT DIAGRAM]

* amend pension charges
* delete pension charges
* retrieve pension charges

#### Individual Reliefs

These endpoints allow a user to amend, delete and retrieve relief investments from VCT subscriptions, EIS subscriptions, Community Investments, Seed Enterprise Investments and Social Enterprise Investments.

[INSERT DIAGRAM]

* amend individual reliefs
* delete individual reliefs
* retrieve individual reliefs

#### Other deductions

At present this only relates to seafarers, but other deductions will be added in future.

These endpoints allow a user to manage their data related to deductions from their tax bill.

The user can submit details of their deductions for a specific tax year, as well as amend submissions already made.  They also have the option to delete previous submissions, and to retrieve the information they have previously submitted. 

The new functionality provides three endpoints, to submit or amend deductions, delete a submission, or retrieve details of a submission.

[INSERT DIAGRAM]

Amend (PUT)
Delete (Delete)
Retrieve (GET)

#### Individual expenses other

These endpoints allow the user to  manage their data related to expenses income for trade union and patent royalties.

The user can submit details of their expenses income for a specific tax year, as well as amend submissions already made.  They also have the option to delete previous submissions, and to retrieve the information they have previously submitted. 

The new functionality provides three endpoints, to submit or amend expenses income, delete a submission, or retrieve details of a submission.

Amend (PUT)
Delete (Delete)
Retrieve (GET)
