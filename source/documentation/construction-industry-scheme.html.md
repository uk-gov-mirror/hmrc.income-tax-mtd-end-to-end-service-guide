---
title: Construction Industry Scheme
weight: 4
description: Software developers, designers, product owners or business analysts. Integrate your software with the Income Tax API for Making Tax Digital.
---

<!--- Section owner: MTD Programme --->

# Construction Industry Scheme

These endpoints allow a subcontractor working under the [Construction Industry Scheme (CIS)](https://www.gov.uk/what-is-the-construction-industry-scheme) to retrieve, submit, amend and delete the gross income, cost of materials and tax deducted amounts if they disagree with the amounts submitted on their behalf by the contractors they have worked for during the tax year. The tax deducted by the contractor will be credited to the subcontractor within their tax calculation.

The user may use these endpoints at least at the point of every quarterly submission. When sending their quarterly update and retrieving a tax calculation that will include the tax deducted by the contractor, the user may want to call these endpoints to query or check the data supplied by the contractor and correct or amend as needed. If no data from the contractor is included in the calculation, the user may want to submit the details so that they can be given credit for the tax the contractor has deducted on their behalf. If the user later realises the data they have is incorrect they can simply delete the data using the delete endpoint.

[Create CIS Deductions for Subcontractor](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/cis-deductions-api/1.0#_create-cis-deductions-for-subcontractor-test-only_post_accordion) - this endpoint allows a developer to create a customer amendment to the CIS deductions which have been previously populated by data submitted directly to HMRC by the contractor. A National Insurance number must be provided.

<a href="figures/cis-create-cis.svg" target="blank"><img src="figures/cis-create-cis.svg" alt="CIS create diagram" style="width:720px;" /></a>
<a href="figures/cis-create-cis.svg" target="blank">Open the CIS create deduction diagram in a new tab</a>.

[Amend CIS Deductions for Subcontractor](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/cis-deductions-api/1.0#_amend-cis-deductions-for-subcontractor-test-only_put_accordion) - this endpoint allows a developer to amend customer CIS deductions that have been previously submitted by the user.  A National Insurance number and submission ID must be provided.

<a href="figures/cis-amend-cis.svg" target="blank"><img src="figures/cis-amend-cis.svg" alt="CIS amend diagram" style="width:720px;" /></a>
<a href="figures/cis-amend-cis.svg" target="blank">Open the CIS amend deduction diagram in a new tab</a>.

[Retrieve CIS Deductions for Subcontractor](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/cis-deductions-api/1.0#_retrieve-cis-deductions-for-subcontractor-test-only_get_accordion) - this endpoint allows a developer to retrieve the latest CIS deductions position and whether contractor or user data has been used. A National Insurance number and submission ID must be provided. 

<a href="figures/cis-retrieve-cis.svg" target="blank"><img src="figures/cis-retrieve-cis.svg" alt="CIS create diagram" style="width:720px;" /></a>
<a href="figures/cis-retrieve-cis.svg" target="blank">Open the CIS retrieve deduction diagram in a new tab</a>.

[Delete CIS Deductions for Subcontractor](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/cis-deductions-api/1.0#_delete-cis-deductions-for-subcontractor-test-only_delete_accordion) - this endpoint allows a developer to delete customer CIS amendment deductions which have been previously submitted. A National Insurance number and submission ID must be provided.

<a href="figures/cis-delete-cis.svg" target="blank"><img src="figures/cis-delete-cis.svg" alt="CIS delete diagram" style="width:720px;" /></a>
<a href="figures/cis-delete-cis.svg" target="blank">Open the CIS delete deduction diagram in a new tab</a>.




