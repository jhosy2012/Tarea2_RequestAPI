Feature: Project
  Scenario: I have authentication to todo.ly

    Given I have authentication to todo.ly
    When I send POST request 'api/items.json' with json
    """
    {
       "Content":"CUCUMBER",
    }
    """

    Then I expected the response code 200
    And I expected the response body es equal
    """
    {
        "Id": "EXCLUDE",
        "Content": "CUCUMBER",
        "ItemType": 1,
        "Checked": false,
        "ProjectId": null,
        "ParentId": null,
        "Path": "",
        "Collapsed": false,
        "DateString": null,
        "DateStringPriority": 0,
        "DueDate": "",
        "Recurrence": null,
        "ItemOrder": null,
        "Priority": 4,
        "LastSyncedDateTime": "EXCLUDE",
        "Children": [],
        "DueDateTime": null,
        "CreatedDate": "EXCLUDE",
        "LastCheckedDate": null,
        "LastUpdatedDate": "EXCLUDE",
        "Deleted": false,
        "Notes": "",
        "InHistory": false,
        "SyncClientCreationId": null,
        "DueTimeSpecified": true,
        "OwnerId": EXCLUDE
    }
    """



    And I get the property value 'Id' and save on ID_ITEM
    And I get the property value 'Content' and save on NAME_ITEM

    When I send PUT request 'api/items/ID_ITEM.json' with json
    """
    {
       "Content":"NAME_ITEM update V1",
    }
    """

    Then I expected the response code 200
    And I expected the response body es equal
    """
    {
        "Id": "ID_ITEM",
        "Content": "NAME_ITEM update V1",
        "ItemType": 1,
        "Checked": false,
        "ProjectId": null,
        "ParentId": null,
        "Path": "",
        "Collapsed": false,
        "DateString": null,
        "DateStringPriority": 0,
        "DueDate": "",
        "Recurrence": null,
        "ItemOrder": null,
        "Priority": 4,
        "LastSyncedDateTime": "EXCLUDE",
        "Children": [],
        "DueDateTime": null,
        "CreatedDate": "EXCLUDE",
        "LastCheckedDate": null,
        "LastUpdatedDate": "EXCLUDE",
        "Deleted": false,
        "Notes": "",
        "InHistory": false,
        "SyncClientCreationId": null,
        "DueTimeSpecified": true,
        "OwnerId": EXCLUDE
    }
    """

    When I send GET request 'api/items/ID_ITEM.json' with json
    """
    """
    Then I expected the response code 200
    And I expected the response body es equal
    """
    {
        "Id": "ID_ITEM",
        "Content": "EXCLUDE",
        "ItemType": 1,
        "Checked": false,
        "ProjectId": null,
        "ParentId": null,
        "Path": "",
        "Collapsed": false,
        "DateString": null,
        "DateStringPriority": 0,
        "DueDate": "",
        "Recurrence": null,
        "ItemOrder": null,
        "Priority": 4,
        "LastSyncedDateTime": "EXCLUDE",
        "Children": [],
        "DueDateTime": null,
        "CreatedDate": "EXCLUDE",
        "LastCheckedDate": null,
        "LastUpdatedDate": "EXCLUDE",
        "Deleted": false,
        "Notes": "",
        "InHistory": false,
        "SyncClientCreationId": null,
        "DueTimeSpecified": true,
        "OwnerId": EXCLUDE
    }
    """

    When I send DELETE request 'api/items/ID_ITEM.json' with json
    """
    """
    Then I expected the response code 200
    And I expected the response body es equal
    """
    {
        "Id": "ID_ITEM",
        "Content": "EXCLUDE",
        "ItemType": 1,
        "Checked": false,
        "ProjectId": null,
        "ParentId": null,
        "Path": "",
        "Collapsed": false,
        "DateString": null,
        "DateStringPriority": 0,
        "DueDate": "",
        "Recurrence": null,
        "ItemOrder": null,
        "Priority": 4,
        "LastSyncedDateTime": "EXCLUDE",
        "Children": [],
        "DueDateTime": null,
        "CreatedDate": "EXCLUDE",
        "LastCheckedDate": null,
        "LastUpdatedDate": "EXCLUDE",
        "Deleted": true,
        "Notes": "",
        "InHistory": false,
        "SyncClientCreationId": null,
        "DueTimeSpecified": true,
        "OwnerId": EXCLUDE
    }
    """