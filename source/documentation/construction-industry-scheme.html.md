---
title: Construction Industry Scheme
weight: 4
description: Software developers, designers, product owners or business analysts. Integrate your software with the Income Tax API for Making Tax Digital.
---

<!--- Section owner: MTD Programme --->

# Construction Industry Scheme

These endpoints allow a subcontractor working within the Construction Industry Scheme to retrieve, submit, amend and delete the gross income, cost of materials and tax deducted amounts if they disagree with the amounts submitted on their behalf by the contractors they have worked for during the tax year. The tax deducted by the contractor will be credited to the subcontractor within their tax calculation.

The user may use these endpoints at least at the point of every quarterly submission. When sending their quarterly update and retrieving a tax calculation that will include the tax deducted by the contractor, the user may want to call these endpoints to query / check the data supplied by the contractor and correct / amend as needed. If no data from the contractor is included in the calculation, the user may want to submit the details so that they can be given credit for the tax the contractor has deducted on their behalf. If the user later realise the data they have is incorrect they can simply delete the data using the delete endpoint.

[INSERT DIAGRAMS]

CREATE CIS Deductions for Subcontractor - This endpoint allows a developer to create a customer amendment to the CIS deductions which have been previously populated by data submitted directly to HMRC by the contractor. A National Insurance number must be provided
AMEND CIS Deductions for Subcontractor - This endpoint allows a developer to amend customer CIS deductions that have been previously submitted by the user. A National Insurance number and submission ID must be provided.
LIST CIS Deductions for Subcontractor -This endpoint allows a developer to retrieve the latest CIS deductions position and whether contractor or user data has been used. A National Insurance number and submission ID must be provided.
DELETE CIS Deductions for Subcontractor - This endpoint allows a developer to delete customer CIS amendment deductions which have been previously submitted. A National Insurance number and submission ID must be provided.
