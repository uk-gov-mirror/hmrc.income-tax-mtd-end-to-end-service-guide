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

HMRC will pre-populate the employment information provided by employers. The user should check and correct the information, as necessary, prior to crystallisation. 

**Note:** 

Pre-populated data can only be stopped (ignored) from being used in any tax calculation.

User-generated content:

* can be deleted
* will only be applied in the tax calculation 
* will not overwrite pre-populated data

Custom employments will only apply to the tax year and will not be carried over in subsequent years.  The expenses values are summed values from all PAYE employments, they are not available by employment.


## Other Employment Income

These endpoints allow a user to retrieve other employment income: Share options, Shares awarded or received, Disability and Foreign service.

* [Retrieve Other Employment Income [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-income-received-api/1.0#other-employment-income_retrieve-other-employment-income-test-only_get_accordion)
* [Amend Other Employment Income [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-income-received-api/1.0#other-employment-income_amend-other-employment-income-test-only_put_accordion)
* [Delete Other Employment Income [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-income-received-api/1.0#other-employment-income_delete-other-employment-income-test-only_delete_accordion)


<a href="figures/other-employment-income.svg" target="blank">
<img src="figures/other-employment-income.svg" alt=" " style="width:720px;" />
</a>
<a href="figures/other-employment-income.svg" target="blank">Open diagram in a new tab.</a>

## Dividends income

These endpoints allow a user to retrieve, amend and delete dividends income: foreign dividend, dividend income received whilst abroad, stock dividend, redeemable shares, bonus issues of securities and close company loans written off.

* [Retrieve Dividends Income [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-income-received-api/1.0#dividends-income_retrieve-dividends-income-test-only_get_accordion)
* [Amend Dividends Income [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-income-received-api/1.0#dividends-income_amend-dividends-income-test-only_put_accordion)
* [Delete Dividends Income [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-income-received-api/1.0#dividends-income_delete-dividends-income-test-only_delete_accordion)

<a href="figures/dividends-income.svg" target="blank">
<img src="figures/dividends-income.svg" alt=" " style="width:720px;" />
</a>
<a href="figures/dividends-income.svg" target="blank">Open diagram in a new tab.</a>

## Foreign income

These endpoints give the user the ability to manage their data related to foreign earnings and unremittable foreign income.

The user can submit details of their foreign earnings and foreign income for a specific tax year, as well as amend submissions already made.  They also have the option to delete previous submissions, and to retrieve the information they have previously submitted. 

The new functionality provides three endpoints, to submit or amend foreign earnings and foreign income, delete a submission, or retrieve details of a submission.

* [Amend Foreign Income [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-income-received-api/1.0#foreign-income_amend-foreign-income-test-only_put_accordion)
* [Retrieve Foreign Income [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-income-received-api/1.0#foreign-income_retrieve-foreign-income-test-only_get_accordion)
* [Delete Foreign Income [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-income-received-api/1.0#foreign-income_delete-foreign-income-test-only_delete_accordion)

<a href="figures/foreign-reliefs.svg" target="blank">
<img src="figures/foreign-reliefs.svg" alt=" " style="width:720px;" />
</a>
<a href="figures/foreign-reliefs.svg" target="blank">Open diagram in a new tab.</a>

## Insurance policies income

These endpoints allow a user to retrieve, amend and delete insurance policies and income for less common types of income: Life Insurance Policies, Life Annuity Contracts, Capital Redemption Policies, Voided ISAs, Foreign Policies. A National Insurance number and tax year must be provided.

* [Retrieve Insurance Policies Income [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-income-received-api/1.0#insurance-policies-income_retrieve-insurance-policies-income-test-only_get_accordion)
* [Amend Insurance Policies Income [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-income-received-api/1.0#insurance-policies-income_amend-insurance-policies-income-test-only_put_accordion)
* [Delete Insurance Policies Income [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-income-received-api/1.0#insurance-policies-income_delete-insurance-policies-income-test-only_delete_accordion)

<a href="figures/insurance-policies-income.svg" target="blank">
<img src="figures/insurance-policies-income.svg" alt=" " style="width:720px;" />
</a>
<a href="figures/insurance-policies-income.svg" target="blank">Open diagram in a new tab.</a>

## Pensions income

These endpoints allow a user to retrieve, amend and delete previously populated foreign pensions and overseas pension contributions.

* [Retrieve Pensions Income [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-income-received-api/1.0#pensions-income_retrieve-pensions-income-test-only_get_accordion)
* [Amend Pensions Income [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-income-received-api/1.0#pensions-income_amend-pensions-income-test-only_put_accordion)
* [Delete Pensions Income [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-income-received-api/1.0#pensions-income_delete-pensions-income-test-only_delete_accordion)

<a href="figures/pensions-income.svg" target="blank">
<img src="figures/pensions-income.svg" alt=" " style="width:720px;" />
</a>
<a href="figures/pensions-income.svg" target="blank">Open diagram in a new tab.</a>

## Other income

These endpoints allow a user to retrieve other income: business receipts, all other income received whilst abroad, overseas income and gains, chargeable foreign benefits and gifts and omitted foreign income.

* [Retrieve Pensions Income [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-income-received-api/1.0#pensions-income_retrieve-pensions-income-test-only_get_accordion)
* [Amend Pensions Income [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-income-received-api/1.0#pensions-income_amend-pensions-income-test-only_put_accordion)
* [Delete Pensions Income [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-income-received-api/1.0#pensions-income_delete-pensions-income-test-only_delete_accordion)

<a href="figures/other-income.svg" target="blank">
<img src="figures/other-income.svg" alt=" " style="width:720px;" />
</a>
<a href="figures/other-income.svg" target="blank">Open diagram in a new tab.</a>

## Savings income

These endpoints allow a user to retrieve, amend and delete savings income for securities or foreign interest.

* [Retrieve Savings Income [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-income-received-api/1.0#savings-income_retrieve-savings-income-test-only_get_accordion)
* [Amend Savings Income [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-income-received-api/1.0#savings-income_amend-savings-income-test-only_put_accordion)
* [Delete Savings Income [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-income-received-api/1.0#savings-income_delete-savings-income-test-only_delete_accordion)

<a href="figures/savings-income.svg" target="blank">
<img src="figures/savings-income.svg" alt=" " style="width:720px;" />
</a>
<a href="figures/savings-income.svg" target="blank">Open diagram in a new tab.</a>

## Disclosures

This endpoint allows the user to manage their data related to the disclosure of tax avoidance schemes and undeclared income, for a given tax year. 

The user can submit details of any disclosures for a specific tax year, as well as amend submissions already made.  They also have the option to delete previous submissions, and to retrieve the information they have previously submitted. 

The new functionality provides three endpoints, to submit or amend disclosures, delete a submission, or retrieve details of a submission.

The user would normally call this when they have all the information necessary for disclosures for the tax year.

* [Retrieve Disclosures [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-disclosures-api/1.0#disclosures_retrieve-disclosures-test-only_get_accordion)
* [Amend Disclosures [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-disclosures-api/1.0#disclosures_amend-disclosures-test-only_put_accordion)
* [Delete Disclosures [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-disclosures-api/1.0#disclosures_delete-disclosures-test-only_delete_accordion)

<a href="figures/disclosures.svg" target="blank">
<img src="figures/disclosures.svg" alt=" " style="width:720px;" />
</a>
<a href="figures/disclosures.svg" target="blank">Open diagram in a new tab.</a>

## Pension charges

These endpoints allow a user to manage data related to pension contributions and charges. The user can submit details of pension contributions and charges for a specific tax year, as well as amend submissions already made. The user also has the option to delete previous submissions, and to retrieve the information they have previously submitted.
 
The new functionality provides three new endpoints: amend new pension charges, delete a submission, and retrieve details of a submission.

* [Retrieve Pension Charges](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-charges-api/1.0#_retrieve-pension-charges_get_accordion)
* [Amend Pension Charges](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-charges-api/1.0#_amend-pension-charges_put_accordion)
* [Delete Pension Charges](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-charges-api/1.0#_delete-pension-charges_delete_accordion)

<a href="figures/pension-charges.svg" target="blank">
<img src="figures/pension-charges.svg" alt=" " style="width:720px;" />
</a>
<a href="figures/pension-charges.svg" target="blank">Open diagram in a new tab.</a>

## Pension reliefs

These endpoints give the user the ability to manage data related to reliefs on pensions.  The user can submit details of reliefs on pensions for a specific tax year, as well as amend submissions already made.  They also have the option to delete previous submissions, and to retrieve the information they have previously submitted.
 
The new functionality provides three new endpoints: submit or amend new reliefs on pensions, delete a submission, or retrieve details of a submission.

* [Retrieve Pensions Reliefs [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-reliefs-api/1.0#pensions-reliefs_retrieve-pensions-reliefs-test-only_get_accordion)
* [Amend Pensions Reliefs [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-reliefs-api/1.0#pensions-reliefs_amend-pensions-reliefs-test-only_put_accordion)
* [Delete Pensions Reliefs [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-reliefs-api/1.0#pensions-reliefs_delete-pensions-reliefs-test-only_delete_accordion)

<a href="figures/pension-reliefs.svg" target="blank">
<img src="figures/pension-reliefs.svg" alt=" " style="width:720px;" />
</a>
<a href="figures/pension-reliefs.svg" target="blank">Open diagram in a new tab.</a>


## Individual Reliefs

These endpoints allow a user to amend, delete and retrieve relief investments from VCT subscriptions, EIS subscriptions, Community Investments, Seed Enterprise Investments and Social Enterprise Investments.

* amend individual reliefs
* delete individual reliefs
* retrieve individual reliefs



## Other deductions

At present this only relates to seafarers, but other deductions will be added in future.

These endpoints allow a user to manage their data related to deductions from their tax bill.

The user can submit details of their deductions for a specific tax year, as well as amend submissions already made.  They also have the option to delete previous submissions, and to retrieve the information they have previously submitted. 

The new functionality provides three endpoints, to submit or amend deductions, delete a submission, or retrieve details of a submission.

* Retrieve deductions [test only](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/other-deductions-api/1.0#_retrieve-deductions-test-only_get_accordion)
* Amend deductions [test only](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/other-deductions-api/1.0#_amend-deductions-test-only_put_accordion)
* Delete deductions [test only](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/other-deductions-api/1.0#_delete-deductions-test-only_delete_accordion)

<a href="figures/other-deductions.svg" target="blank">
<img src="figures/other-deductions.svg" alt=" " style="width:720px;" />
</a>
<a href="figures/other-deductions.svg" target="blank">Open diagram in a new tab.</a>

## Individual expenses other

These endpoints allow the user to  manage their data related to expenses income for trade union and patent royalties.

The user can submit details of their expenses income for a specific tax year, as well as amend submissions already made.  They also have the option to delete previous submissions, and to retrieve the information they have previously submitted. 

The new functionality provides three endpoints, to submit or amend expenses income, delete a submission, or retrieve details of a submission.

* [Retrieve Other Expenses [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-expenses-api/1.0#_retrieve-other-expenses-test-only_get_accordion)
* [Amend Other Expenses [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-expenses-api/1.0#_amend-other-expenses-test-only_put_accordion)
* [Delete Other Expenses [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-expenses-api/1.0#_delete-other-expenses-test-only_delete_accordion)

<a href="figures/expenses-other.svg" target="blank">
<img src="figures/expenses-other.svg" alt=" " style="width:720px;" />
</a>
<a href="figures/expenses-other.svg" target="blank">Open diagram in a new tab.</a>

## State benefits

These endpoints give a user the ability to manage data related to state benefits.  The user can add details about state benefits for a specific tax year, as well as update submissions already made.  They also have the option to delete previous submissions, and to retrieve the information they have previously submitted.
 
The new functionality provides seven new endpoints: Add State Benefit, Delete State Benefit Amounts, Delete State Benefit, Ignore State Benefit, Update State Benefit Amounts, Update State Benefit and Retrieve anlist of all state benefits.

**Note**

* only pre-populated HMRC benefits can be ignored (end-of-year)
* if the customer attempts to delete a pre-populated state benefit then the operation will fail with a forbidden response.
* a customer can only update amounts in-year for ‘Job Seeker Allowance’ and Employment Support Allowance

* [List State Benefits [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-state-benefits-api/1.0#_list-state-benefits-test-only_get_accordion)
* [Add State Benefit [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-state-benefits-api/1.0#_add-state-benefit-test-only_post_accordion)
* [Update State Benefit [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-state-benefits-api/1.0#_update-state-benefit-test-only_put_accordion)
* [Delete State Benefit [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-state-benefits-api/1.0#_delete-state-benefit-test-only_delete_accordion)
* [Update State Benefit Amounts [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-state-benefits-api/1.0#_update-state-benefit-amounts-test-only_put_accordion)
* [Delete State Benefit Amounts [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-state-benefits-api/1.0#_delete-state-benefit-amounts-test-only_delete_accordion)
* [Ignore State Benefit [test only]](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individuals-state-benefits-api/1.0#_ignore-state-benefit-test-only_put_accordion)











