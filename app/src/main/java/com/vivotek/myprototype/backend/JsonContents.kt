package com.vivotek.myprototype.backend

class JsonContents {

    companion object {
        val LIST_MY_ORGANIZATION_JSON = """
        {
          "data": {
            "listMyOrganization": {
              "items": [
                {
                  "inviterEmail": "jason.lu@vivotek.com",
                  "onBoard": true,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "organizationName": "agoodorganization",
                  "licensePhase": "GracePeriod",
                  "licenseMainPlans": [
                    "xStd",
                    "xPro"
                  ],
                  "isFreePlan": false,
                  "storageLocation": "jp",
                  "isRequiredMFA": false,
                  "username": "☄️☄️☄️☄️☄️☄️☄️☄️☄️☄️☄️☄️☄️☄️☄️☄️☄️☄️☄️",
                  "snoozeUntil": null,
                  "support": [
                    "FloorPlan",
                    "LicensePlateRecognition"
                  ]
                }
              ]
            }
          }
        }
        """.trimIndent()

        val GET_SITES_JSON = """
        {"sites":[{"id":"aaa10000-0000-0000-0000-000000000001","name":"Headquarters","parentId":"","location":{"latitude":25.033,"longitude":121.565,"address":"Taipei, Taiwan"}},{"id":"aaa20000-0000-0000-0000-000000000002","name":"Building A","parentId":"aaa10000-0000-0000-0000-000000000001"},{"id":"aaa30000-0000-0000-0000-000000000003","name":"Building B","parentId":"aaa10000-0000-0000-0000-000000000001"},{"id":"aaa40000-0000-0000-0000-000000000004","name":"Floor 1","parentId":"aaa30000-0000-0000-0000-000000000003"},{"id":"aaa50000-0000-0000-0000-000000000005","name":"Floor 2","parentId":"aaa30000-0000-0000-0000-000000000003"},{"id":"bbb10000-0000-0000-0000-000000000001","name":"Branch Office","parentId":"","location":{"latitude":35.6585,"longitude":139.7454,"address":"Tokyo, Japan"}},{"id":"bbb20000-0000-0000-0000-000000000002","name":"Lobby","parentId":"bbb10000-0000-0000-0000-000000000001"},{"id":"6d179369-0e0b-48e7-8024-882c925c057c","name":"Ungrouped Cameras","parentId":""}]}
        """.trimIndent()

        val LIST_CLOUD_STORAGE_JSON ="""
        {
          "data": {
            "listCloudStorageConfig": {
              "items": [
                {
                  "location": "de",
                  "storages": {
                    "device": {
                      "region": "eu-central-1",
                      "name": "dev-vsaas-vortex-storage-de"
                    }
                  }
                },
                {
                  "location": "jp",
                  "storages": {
                    "device": {
                      "region": "ap-northeast-1",
                      "name": "hulk-devices-push-storage-the-greate-one-vsaas-vortex-dev"
                    }
                  }
                },
                {
                  "location": "us",
                  "storages": {
                    "device": {
                      "region": "us-west-2",
                      "name": "dev-vsaas-vortex-storage-us"
                    }
                  }
                },
                {
                  "location": "au",
                  "storages": {
                    "device": {
                      "region": "ap-southeast-2",
                      "name": "dev-vsaas-vortex-storage-au"
                    }
                  }
                }
              ]
            }
          }
        }
        """.trimIndent()

        val LIST_DEVICES_JSON = """
        {
          "data": {
            "listDeviceInfoOfOrganization": {
              "items": [
                {
                  "derivant": "none",
                  "derivantMac": null,
                  "siteID": "aaa20000-0000-0000-0000-000000000002",
                  "firmware": "6.371.62",
                  "fisheye": false,
                  "ip": "172.18.2.9",
                  "mac": "0002D1AA818C",
                  "model": "FD837-HTV",
                  "name": "456",
                  "online": true,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": true,
                  "recordingCapacityDays": 30,
                  "isCustomRetentionDaysEnabled": false,
                  "recordingType": null,
                  "thingName": "0002D1AA818C-1758866186089",
                  "type": "camera",
                  "city": "AmericaLosAngeles",
                  "timezone": "PST8PDT,M3.2.0,M11.1.0",
                  "ptz": false,
                  "modelType": "Premium",
                  "fwUpgradeVersion": null,
                  "fwUpgradeState": null,
                  "storageCapacity": 30,
                  "archiveLimitedSize": null,
                  "wizardFinished": null,
                  "support": [
                    "recording",
                    "audio",
                    "di",
                    "do",
                    "rtsp-access",
                    "scenemode",
                    "tampering-smart",
                    "webhook",
                    "audioin",
                    "remotefocus",
                    "webhook-v2",
                    "timelapse",
                    "videoin_stream3",
                    "daynight",
                    "ipspeaker-multiaudio",
                    "privacy-mask",
                    "audioout",
                    "audioclip",
                    "retentionDaysByUser"
                  ],
                  "protocol": null
                },
                {
                  "derivant": "none",
                  "derivantMac": null,
                  "siteID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "firmware": null,
                  "fisheye": false,
                  "ip": null,
                  "mac": "0002D1ABF555",
                  "model": null,
                  "name": "555",
                  "online": false,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": false,
                  "recordingCapacityDays": null,
                  "isCustomRetentionDaysEnabled": null,
                  "recordingType": null,
                  "thingName": "0002D1ABF555-1754903785823",
                  "type": "unknownDevice",
                  "city": "AmericaLosAngeles",
                  "timezone": null,
                  "ptz": false,
                  "modelType": "Unknown",
                  "fwUpgradeVersion": null,
                  "fwUpgradeState": null,
                  "storageCapacity": null,
                  "archiveLimitedSize": 0,
                  "wizardFinished": null,
                  "support": null,
                  "protocol": null
                },
                {
                  "derivant": "none",
                  "derivantMac": null,
                  "siteID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "firmware": null,
                  "fisheye": false,
                  "ip": null,
                  "mac": "0002D1ABF556",
                  "model": null,
                  "name": "556",
                  "online": false,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": false,
                  "recordingCapacityDays": null,
                  "isCustomRetentionDaysEnabled": null,
                  "recordingType": null,
                  "thingName": "0002D1ABF556-1754903911816",
                  "type": "unknownDevice",
                  "city": "AmericaLosAngeles",
                  "timezone": null,
                  "ptz": false,
                  "modelType": "Unknown",
                  "fwUpgradeVersion": null,
                  "fwUpgradeState": null,
                  "storageCapacity": null,
                  "archiveLimitedSize": 0,
                  "wizardFinished": null,
                  "support": null,
                  "protocol": null
                },
                {
                  "derivant": "none",
                  "derivantMac": null,
                  "siteID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "firmware": null,
                  "fisheye": false,
                  "ip": null,
                  "mac": "0002D1ABF557",
                  "model": null,
                  "name": "557",
                  "online": false,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": false,
                  "recordingCapacityDays": null,
                  "isCustomRetentionDaysEnabled": null,
                  "recordingType": null,
                  "thingName": "0002D1ABF557-1754903963553",
                  "type": "unknownDevice",
                  "city": "AmericaLosAngeles",
                  "timezone": null,
                  "ptz": false,
                  "modelType": "Unknown",
                  "fwUpgradeVersion": null,
                  "fwUpgradeState": null,
                  "storageCapacity": null,
                  "archiveLimitedSize": 0,
                  "wizardFinished": null,
                  "support": null,
                  "protocol": null
                },
                {
                  "derivant": "none",
                  "derivantMac": null,
                  "siteID": "aaa20000-0000-0000-0000-000000000002",
                  "firmware": "6.33.52",
                  "fisheye": false,
                  "ip": "172.18.1.105",
                  "mac": "0002D1987F23",
                  "model": "FD819-H",
                  "name": "CAM_85",
                  "online": true,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": true,
                  "recordingCapacityDays": 30,
                  "isCustomRetentionDaysEnabled": false,
                  "recordingType": null,
                  "thingName": "0002D1987F23-1705461644301",
                  "type": "camera",
                  "city": "PacificWake",
                  "timezone": "WAKT-12",
                  "ptz": false,
                  "modelType": "Essential",
                  "fwUpgradeVersion": null,
                  "fwUpgradeState": null,
                  "storageCapacity": 30,
                  "archiveLimitedSize": null,
                  "wizardFinished": null,
                  "support": [
                    "tampering-smart",
                    "privacy-mask",
                    "webhook",
                    "videoin_stream3",
                    "rtsp-access",
                    "webhook-v2",
                    "timelapse",
                    "daynight",
                    "recording",
                    "scenemode",
                    "ipspeaker-multiaudio",
                    "audioin",
                    "retentionDaysByUser"
                  ],
                  "protocol": null
                },
                {
                  "derivant": "none",
                  "derivantMac": null,
                  "siteID": "aaa30000-0000-0000-0000-000000000003",
                  "firmware": "6.33.52",
                  "fisheye": false,
                  "ip": "172.18.1.126",
                  "mac": "0002D1987F0A",
                  "model": "FD819-H",
                  "name": "CAM_8666",
                  "online": true,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": true,
                  "recordingCapacityDays": 30,
                  "isCustomRetentionDaysEnabled": false,
                  "recordingType": null,
                  "thingName": "0002D1987F0A-1717738593191",
                  "type": "camera",
                  "city": "AsiaDubai",
                  "timezone": "GST-4",
                  "ptz": false,
                  "modelType": "Essential",
                  "fwUpgradeVersion": null,
                  "fwUpgradeState": null,
                  "storageCapacity": 30,
                  "archiveLimitedSize": null,
                  "wizardFinished": null,
                  "support": [
                    "audioin",
                    "webhook",
                    "videoin_stream3",
                    "tampering-smart",
                    "scenemode",
                    "rtsp-access",
                    "privacy-mask",
                    "webhook-v2",
                    "daynight",
                    "timelapse",
                    "ipspeaker-multiaudio",
                    "recording",
                    "retentionDaysByUser"
                  ],
                  "protocol": null
                },
                {
                  "derivant": "none",
                  "derivantMac": null,
                  "siteID": "bbb20000-0000-0000-0000-000000000002",
                  "firmware": "6.33.52",
                  "fisheye": false,
                  "ip": "192.168.2.3",
                  "mac": "0002D19C14A0",
                  "model": "IB839-EHT",
                  "name": "CAM_87",
                  "online": true,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": true,
                  "recordingCapacityDays": 30,
                  "isCustomRetentionDaysEnabled": false,
                  "recordingType": null,
                  "thingName": "0002D19C14A0-1719904486984",
                  "type": "camera",
                  "city": "AmericaLosAngeles",
                  "timezone": "PST8PDT,M3.2.0,M11.1.0",
                  "ptz": false,
                  "modelType": "Essential",
                  "fwUpgradeVersion": null,
                  "fwUpgradeState": null,
                  "storageCapacity": 30,
                  "archiveLimitedSize": null,
                  "wizardFinished": null,
                  "support": [
                    "ipspeaker-multiaudio",
                    "webhook",
                    "scenemode",
                    "webhook-v2",
                    "daynight",
                    "tampering-smart",
                    "remotefocus",
                    "recording",
                    "rtsp-access",
                    "timelapse",
                    "videoin_stream3",
                    "privacy-mask",
                    "retentionDaysByUser"
                  ],
                  "protocol": null
                },
                {
                  "derivant": "ch0",
                  "derivantMac": "0002D1B0D43D",
                  "siteID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "firmware": "1.2401.37.01c",
                  "fisheye": false,
                  "ip": "172.18.2.138",
                  "mac": "0002D1ABF6DC",
                  "model": "CC9391-HV",
                  "name": "Camera 01",
                  "online": true,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": true,
                  "recordingCapacityDays": null,
                  "isCustomRetentionDaysEnabled": null,
                  "recordingType": "dual_stream",
                  "thingName": "0002D1ABF6DC-1745200736846",
                  "type": "nvrchannel",
                  "city": null,
                  "timezone": null,
                  "ptz": false,
                  "modelType": "Unknown",
                  "fwUpgradeVersion": null,
                  "fwUpgradeState": 11,
                  "storageCapacity": null,
                  "archiveLimitedSize": 0,
                  "wizardFinished": null,
                  "support": null,
                  "protocol": "VIVOTEK"
                },
                {
                  "derivant": "ch1",
                  "derivantMac": "0002D1B0D44D",
                  "siteID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "firmware": "1.2401.37.01c",
                  "fisheye": false,
                  "ip": "172.18.2.136",
                  "mac": "0002D1ABF6DC",
                  "model": "CC9391-HV",
                  "name": "Camera 02 Test",
                  "online": true,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": true,
                  "recordingCapacityDays": null,
                  "isCustomRetentionDaysEnabled": null,
                  "recordingType": "dual_stream",
                  "thingName": "0002D1ABF6DC-1745200736846",
                  "type": "nvrchannel",
                  "city": null,
                  "timezone": null,
                  "ptz": false,
                  "modelType": "Unknown",
                  "fwUpgradeVersion": null,
                  "fwUpgradeState": 11,
                  "storageCapacity": null,
                  "archiveLimitedSize": 0,
                  "wizardFinished": null,
                  "support": null,
                  "protocol": "VIVOTEK"
                },
                {
                  "derivant": "ch2",
                  "derivantMac": "0002D1B0D43E",
                  "siteID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "firmware": "1.2401.37.01c",
                  "fisheye": false,
                  "ip": "172.18.2.128",
                  "mac": "0002D1ABF6DC",
                  "model": "CC9391-HV",
                  "name": "Camera 03",
                  "online": true,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": true,
                  "recordingCapacityDays": null,
                  "isCustomRetentionDaysEnabled": null,
                  "recordingType": "dual_stream",
                  "thingName": "0002D1ABF6DC-1745200736846",
                  "type": "nvrchannel",
                  "city": null,
                  "timezone": null,
                  "ptz": false,
                  "modelType": "Unknown",
                  "fwUpgradeVersion": null,
                  "fwUpgradeState": 11,
                  "storageCapacity": null,
                  "archiveLimitedSize": 0,
                  "wizardFinished": null,
                  "support": null,
                  "protocol": "VIVOTEK"
                },
                {
                  "derivant": "ch3",
                  "derivantMac": "0002D1B0D43F",
                  "siteID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "firmware": "1.2401.37.01c",
                  "fisheye": false,
                  "ip": "172.18.2.26",
                  "mac": "0002D1ABF6DC",
                  "model": "CC9391-HV",
                  "name": "Camera 04",
                  "online": true,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": true,
                  "recordingCapacityDays": null,
                  "isCustomRetentionDaysEnabled": null,
                  "recordingType": "dual_stream",
                  "thingName": "0002D1ABF6DC-1745200736846",
                  "type": "nvrchannel",
                  "city": null,
                  "timezone": null,
                  "ptz": false,
                  "modelType": "Unknown",
                  "fwUpgradeVersion": null,
                  "fwUpgradeState": 11,
                  "storageCapacity": null,
                  "archiveLimitedSize": 0,
                  "wizardFinished": null,
                  "support": null,
                  "protocol": "VIVOTEK"
                },
                {
                  "derivant": "none",
                  "derivantMac": null,
                  "siteID": "aaa40000-0000-0000-0000-000000000004",
                  "firmware": "6.43.57",
                  "fisheye": false,
                  "ip": "172.18.1.241",
                  "mac": "0002D1B8624D",
                  "model": "IT939-HTVW",
                  "name": "Dante 機器",
                  "online": true,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": true,
                  "recordingCapacityDays": 30,
                  "isCustomRetentionDaysEnabled": false,
                  "recordingType": null,
                  "thingName": "0002D1B8624D-1762394052052",
                  "type": "camera",
                  "city": "AmericaLosAngeles",
                  "timezone": "PST8PDT,M3.2.0,M11.1.0",
                  "ptz": false,
                  "modelType": "Premium",
                  "fwUpgradeVersion": null,
                  "fwUpgradeState": null,
                  "storageCapacity": 30,
                  "archiveLimitedSize": null,
                  "wizardFinished": null,
                  "support": [
                    "di",
                    "recording",
                    "rtsp-access",
                    "audio",
                    "audioin",
                    "audioout",
                    "webhook",
                    "audioclip",
                    "do",
                    "privacy-mask",
                    "remotefocus",
                    "timelapse",
                    "videoin_stream3",
                    "webhook-v2",
                    "daynight",
                    "ipspeaker-multiaudio",
                    "scenemode",
                    "tampering-smart",
                    "retentionDaysByUser"
                  ],
                  "protocol": null
                },
                {
                  "derivant": "none",
                  "derivantMac": null,
                  "siteID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "firmware": null,
                  "fisheye": false,
                  "ip": null,
                  "mac": "0002D19333DD",
                  "model": null,
                  "name": "Device 15",
                  "online": false,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": false,
                  "recordingCapacityDays": null,
                  "isCustomRetentionDaysEnabled": null,
                  "recordingType": null,
                  "thingName": "0002D19333DD-1715868106290",
                  "type": "unknownDevice",
                  "city": "AmericaLosAngeles",
                  "timezone": "PST8PDT,M3.2.0,M11.1.0",
                  "ptz": false,
                  "modelType": "Unknown",
                  "fwUpgradeVersion": null,
                  "fwUpgradeState": null,
                  "storageCapacity": null,
                  "archiveLimitedSize": 0,
                  "wizardFinished": null,
                  "support": null,
                  "protocol": null
                },
                {
                  "derivant": "ipspeaker#0002D1995794",
                  "derivantMac": "0002D1995794",
                  "siteID": "aaa20000-0000-0000-0000-000000000002",
                  "firmware": null,
                  "fisheye": false,
                  "ip": null,
                  "mac": "0002D1987F23",
                  "model": "AU-001",
                  "name": "Device 29",
                  "online": false,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": false,
                  "recordingCapacityDays": null,
                  "isCustomRetentionDaysEnabled": null,
                  "recordingType": null,
                  "thingName": "0002D1987F23-1705461644301",
                  "type": "ipspeaker",
                  "city": null,
                  "timezone": null,
                  "ptz": false,
                  "modelType": "Unknown",
                  "fwUpgradeVersion": null,
                  "fwUpgradeState": null,
                  "storageCapacity": null,
                  "archiveLimitedSize": 0,
                  "wizardFinished": null,
                  "support": null,
                  "protocol": null
                },
                {
                  "derivant": "ipspeaker#0002D1B9C303",
                  "derivantMac": "0002D1B9C303",
                  "siteID": "aaa40000-0000-0000-0000-000000000004",
                  "firmware": null,
                  "fisheye": false,
                  "ip": null,
                  "mac": "0002D1BC4949",
                  "model": "AU-003",
                  "name": "Device 40",
                  "online": false,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": false,
                  "recordingCapacityDays": null,
                  "isCustomRetentionDaysEnabled": null,
                  "recordingType": null,
                  "thingName": "0002D1BC4949-1745479175599",
                  "type": "ipspeaker",
                  "city": null,
                  "timezone": null,
                  "ptz": false,
                  "modelType": "Unknown",
                  "fwUpgradeVersion": null,
                  "fwUpgradeState": null,
                  "storageCapacity": null,
                  "archiveLimitedSize": 0,
                  "wizardFinished": null,
                  "support": null,
                  "protocol": null
                },
                {
                  "derivant": "none",
                  "derivantMac": null,
                  "siteID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "firmware": null,
                  "fisheye": false,
                  "ip": null,
                  "mac": "AB1122334445",
                  "model": null,
                  "name": "KelvinTest",
                  "online": false,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": false,
                  "recordingCapacityDays": null,
                  "isCustomRetentionDaysEnabled": null,
                  "recordingType": null,
                  "thingName": "AB1122334445-1766709947881",
                  "type": "unknownDevice",
                  "city": null,
                  "timezone": null,
                  "ptz": false,
                  "modelType": "Unknown",
                  "fwUpgradeVersion": null,
                  "fwUpgradeState": null,
                  "storageCapacity": null,
                  "archiveLimitedSize": 0,
                  "wizardFinished": null,
                  "support": null,
                  "protocol": null
                },
                {
                  "derivant": "none",
                  "derivantMac": null,
                  "siteID": "bbb10000-0000-0000-0000-000000000001",
                  "firmware": "5.1.0.5.v08122901",
                  "fisheye": false,
                  "ip": "172.18.2.139",
                  "mac": "0002D1ABF6DC",
                  "model": "ND9326P",
                  "name": "NVR本人",
                  "online": true,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": false,
                  "recordingCapacityDays": null,
                  "isCustomRetentionDaysEnabled": null,
                  "recordingType": null,
                  "thingName": "0002D1ABF6DC-1745200736846",
                  "type": "nvr",
                  "city": "AmericaThunderBay",
                  "timezone": "EST5EDT,M3.2.0,M11.1.0",
                  "ptz": false,
                  "modelType": "Unknown",
                  "fwUpgradeVersion": null,
                  "fwUpgradeState": null,
                  "storageCapacity": null,
                  "archiveLimitedSize": 2097152,
                  "wizardFinished": true,
                  "support": [
                    "ptzv3",
                    "webhook",
                    "webhook-v2",
                    "ptzv2",
                    "channelfirmwareupgrade"
                  ],
                  "protocol": null
                },
                {
                  "derivant": "none",
                  "derivantMac": null,
                  "siteID": "aaa40000-0000-0000-0000-000000000004",
                  "firmware": null,
                  "fisheye": false,
                  "ip": null,
                  "mac": "DDDDDDDDDDDD",
                  "model": null,
                  "name": "OpenAPI Test Device",
                  "online": false,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": false,
                  "recordingCapacityDays": null,
                  "isCustomRetentionDaysEnabled": null,
                  "recordingType": null,
                  "thingName": "DDDDDDDDDDDD-1712021708773",
                  "type": "unknownDevice",
                  "city": "AfricaAbidjan",
                  "timezone": "GMT0",
                  "ptz": false,
                  "modelType": "Unknown",
                  "fwUpgradeVersion": null,
                  "fwUpgradeState": null,
                  "storageCapacity": null,
                  "archiveLimitedSize": 0,
                  "wizardFinished": null,
                  "support": null,
                  "protocol": null
                },
                {
                  "derivant": "none",
                  "derivantMac": null,
                  "siteID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "firmware": "4.6.101.2.v08050800",
                  "fisheye": false,
                  "ip": "172.18.2.36",
                  "mac": "0002D1BC4949",
                  "model": "RX9502",
                  "name": "RX as Bridge",
                  "online": true,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": false,
                  "recordingCapacityDays": null,
                  "isCustomRetentionDaysEnabled": null,
                  "recordingType": null,
                  "thingName": "0002D1BC4949-1745479175599",
                  "type": "bridge",
                  "city": "AmericaLosAngeles",
                  "timezone": "PST8PDT,M3.2.0,M11.1.0",
                  "ptz": false,
                  "modelType": "Unknown",
                  "fwUpgradeVersion": "4.6.101.2.v08050800",
                  "fwUpgradeState": 11,
                  "storageCapacity": null,
                  "archiveLimitedSize": 0,
                  "wizardFinished": true,
                  "support": [
                    "ipspeaker-multiaudio",
                    "webhook",
                    "webhook-v2"
                  ],
                  "protocol": null
                },
                {
                  "derivant": "none",
                  "derivantMac": null,
                  "siteID": "bbb20000-0000-0000-0000-000000000002",
                  "firmware": "emulator-v1.0.0",
                  "fisheye": false,
                  "ip": "127.0.0.1",
                  "mac": "888888888888",
                  "model": "Emulator",
                  "name": "Ren_TT",
                  "online": false,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": true,
                  "recordingCapacityDays": null,
                  "isCustomRetentionDaysEnabled": null,
                  "recordingType": null,
                  "thingName": "888888888888-1766478455509",
                  "type": "camera",
                  "city": "AmericaLosAngeles",
                  "timezone": "PST8PDT,M3.2.0,M11.1.0",
                  "ptz": false,
                  "modelType": "Unknown",
                  "fwUpgradeVersion": null,
                  "fwUpgradeState": null,
                  "storageCapacity": 30,
                  "archiveLimitedSize": null,
                  "wizardFinished": null,
                  "support": null,
                  "protocol": null
                },
                {
                  "derivant": "ipspeaker#0002D1B6AE8F",
                  "derivantMac": "0002D1B6AE8F",
                  "siteID": "bbb20000-0000-0000-0000-000000000002",
                  "firmware": null,
                  "fisheye": false,
                  "ip": null,
                  "mac": "0002D1BC4949",
                  "model": "AU-003",
                  "name": "Speaker_AE8F",
                  "online": false,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": false,
                  "recordingCapacityDays": null,
                  "isCustomRetentionDaysEnabled": null,
                  "recordingType": null,
                  "thingName": "0002D1BC4949-1745479175599",
                  "type": "ipspeaker",
                  "city": null,
                  "timezone": null,
                  "ptz": false,
                  "modelType": "Unknown",
                  "fwUpgradeVersion": null,
                  "fwUpgradeState": null,
                  "storageCapacity": null,
                  "archiveLimitedSize": 0,
                  "wizardFinished": null,
                  "support": null,
                  "protocol": null
                },
                {
                  "derivant": "none",
                  "derivantMac": null,
                  "siteID": "aaa50000-0000-0000-0000-000000000005",
                  "firmware": null,
                  "fisheye": false,
                  "ip": null,
                  "mac": "0002D1AA818D",
                  "model": null,
                  "name": "THIS NOT ONLINE",
                  "online": false,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": false,
                  "recordingCapacityDays": null,
                  "isCustomRetentionDaysEnabled": null,
                  "recordingType": null,
                  "thingName": "0002D1AA818D-1750934268833",
                  "type": "unknownDevice",
                  "city": "AsiaTaipei",
                  "timezone": "CST-8",
                  "ptz": false,
                  "modelType": "Unknown",
                  "fwUpgradeVersion": null,
                  "fwUpgradeState": null,
                  "storageCapacity": null,
                  "archiveLimitedSize": 0,
                  "wizardFinished": null,
                  "support": null,
                  "protocol": null
                },
                {
                  "derivant": "none",
                  "derivantMac": null,
                  "siteID": "aaa50000-0000-0000-0000-000000000005",
                  "firmware": "6.37.52",
                  "fisheye": true,
                  "ip": "172.18.1.199",
                  "mac": "027FEDA940A2",
                  "model": "FE911-H",
                  "name": "[低fps] CAM_8800",
                  "online": true,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": true,
                  "recordingCapacityDays": 30,
                  "isCustomRetentionDaysEnabled": false,
                  "recordingType": null,
                  "thingName": "027FEDA940A2-1717468506986",
                  "type": "camera",
                  "city": "AmericaLosAngeles",
                  "timezone": "PST8PDT,M3.2.0,M11.1.0",
                  "ptz": false,
                  "modelType": "Premium",
                  "fwUpgradeVersion": null,
                  "fwUpgradeState": null,
                  "storageCapacity": 30,
                  "archiveLimitedSize": null,
                  "wizardFinished": null,
                  "support": [
                    "tampering-smart",
                    "privacy-mask",
                    "webhook",
                    "webhook-v2",
                    "ipspeaker-multiaudio",
                    "audioclip",
                    "audioout",
                    "audioin",
                    "rtsp-access",
                    "audio",
                    "recording",
                    "timelapse",
                    "videoin_stream3",
                    "scenemode",
                    "daynight",
                    "retentionDaysByUser"
                  ],
                  "protocol": null
                },
                {
                  "derivant": "ipspeaker#200BBBBBBB22",
                  "derivantMac": "200BBBBBBB22",
                  "siteID": "aaa20000-0000-0000-0000-000000000002",
                  "firmware": null,
                  "fisheye": false,
                  "ip": null,
                  "mac": "0002D1987F23",
                  "model": "AU-003",
                  "name": "ipspeaker2",
                  "online": false,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": false,
                  "recordingCapacityDays": null,
                  "isCustomRetentionDaysEnabled": null,
                  "recordingType": "main_stream",
                  "thingName": "0002D1987F23-1705461644301",
                  "type": "ipspeaker",
                  "city": null,
                  "timezone": null,
                  "ptz": false,
                  "modelType": "Unknown",
                  "fwUpgradeVersion": null,
                  "fwUpgradeState": null,
                  "storageCapacity": null,
                  "archiveLimitedSize": 0,
                  "wizardFinished": null,
                  "support": null,
                  "protocol": null
                },
                {
                  "derivant": "none",
                  "derivantMac": null,
                  "siteID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "firmware": null,
                  "fisheye": false,
                  "ip": null,
                  "mac": "123123123127",
                  "model": null,
                  "name": "jasonTest",
                  "online": false,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": false,
                  "recordingCapacityDays": null,
                  "isCustomRetentionDaysEnabled": null,
                  "recordingType": null,
                  "thingName": "123123123127-1753338836389",
                  "type": "unknownDevice",
                  "city": "AmericaLosAngeles",
                  "timezone": null,
                  "ptz": false,
                  "modelType": "Unknown",
                  "fwUpgradeVersion": null,
                  "fwUpgradeState": null,
                  "storageCapacity": null,
                  "archiveLimitedSize": 0,
                  "wizardFinished": null,
                  "support": null,
                  "protocol": null
                },
                {
                  "derivant": "none",
                  "derivantMac": null,
                  "siteID": "bbb10000-0000-0000-0000-000000000001",
                  "firmware": null,
                  "fisheye": false,
                  "ip": null,
                  "mac": "123123123125",
                  "model": null,
                  "name": "jasonTest123123",
                  "online": false,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": false,
                  "recordingCapacityDays": null,
                  "isCustomRetentionDaysEnabled": null,
                  "recordingType": null,
                  "thingName": "123123123125-1753337639285",
                  "type": "unknownDevice",
                  "city": "AmericaLowerPrince",
                  "timezone": null,
                  "ptz": false,
                  "modelType": "Unknown",
                  "fwUpgradeVersion": null,
                  "fwUpgradeState": null,
                  "storageCapacity": null,
                  "archiveLimitedSize": 0,
                  "wizardFinished": null,
                  "support": null,
                  "protocol": null
                },
                {
                  "derivant": "none",
                  "derivantMac": null,
                  "siteID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "firmware": null,
                  "fisheye": false,
                  "ip": null,
                  "mac": "0002D1A40755",
                  "model": null,
                  "name": "joyce測試中勿動",
                  "online": false,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": false,
                  "recordingCapacityDays": null,
                  "isCustomRetentionDaysEnabled": null,
                  "recordingType": null,
                  "thingName": "0002D1A40755-1753944387303",
                  "type": "unknownDevice",
                  "city": "AmericaLosAngeles",
                  "timezone": null,
                  "ptz": false,
                  "modelType": "Unknown",
                  "fwUpgradeVersion": null,
                  "fwUpgradeState": null,
                  "storageCapacity": null,
                  "archiveLimitedSize": 0,
                  "wizardFinished": null,
                  "support": null,
                  "protocol": null
                },
                {
                  "derivant": "none",
                  "derivantMac": null,
                  "siteID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "firmware": null,
                  "fisheye": false,
                  "ip": null,
                  "mac": "AB0111111111",
                  "model": null,
                  "name": "kelvinTestV7",
                  "online": false,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": false,
                  "recordingCapacityDays": null,
                  "isCustomRetentionDaysEnabled": null,
                  "recordingType": null,
                  "thingName": "AB0111111111-1768803386845",
                  "type": "unknownDevice",
                  "city": "AmericaLosAngeles",
                  "timezone": "PST8PDT,M3.2.0,M11.1.0",
                  "ptz": false,
                  "modelType": "Unknown",
                  "fwUpgradeVersion": null,
                  "fwUpgradeState": null,
                  "storageCapacity": null,
                  "archiveLimitedSize": 0,
                  "wizardFinished": null,
                  "support": null,
                  "protocol": null
                },
                {
                  "derivant": "poeSwitch0040C71D536E",
                  "derivantMac": "0040C71D536E",
                  "siteID": "aaa40000-0000-0000-0000-000000000004",
                  "firmware": null,
                  "fisheye": false,
                  "ip": null,
                  "mac": "0002D1BC4949",
                  "model": "AW-GEV-108A-130",
                  "name": "poe536E",
                  "online": false,
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "recording": false,
                  "recordingCapacityDays": null,
                  "isCustomRetentionDaysEnabled": null,
                  "recordingType": "main_stream",
                  "thingName": "0002D1BC4949-1745479175599",
                  "type": "poeSwitch",
                  "city": null,
                  "timezone": null,
                  "ptz": false,
                  "modelType": "Unknown",
                  "fwUpgradeVersion": null,
                  "fwUpgradeState": null,
                  "storageCapacity": null,
                  "archiveLimitedSize": 0,
                  "wizardFinished": null,
                  "support": null,
                  "protocol": null
                }
              ]
            }
          }
        }
        """.trimIndent()

        val LIST_USERS_JSON = """
        {
          "data": {
            "listUserOfOrganizationV2": {
              "items": [
                {
                  "email": "aa20221117@test.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-admin",
                    "name": "Admin"
                  },
                  "onBoard": true,
                  "username": "aa20221118"
                },
                {
                  "email": "aef61051@vogco.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": false,
                  "username": "aef61051"
                },
                {
                  "email": "alive.kuo@vivotek.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-admin",
                    "name": "Admin"
                  },
                  "onBoard": true,
                  "username": "alive.kuo"
                },
                {
                  "email": "asd@dd.cc",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-admin",
                    "name": "Admin"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "bcv61685@fosiq.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "d6ifqih4e0noel9obn3g",
                    "name": "test222"
                  },
                  "onBoard": false,
                  "username": ""
                },
                {
                  "email": "benson.chuang@vivotek.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-admin",
                    "name": "Admin"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "bensontestviewer@marsoak.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "carol.yr.yang@vivotek.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-admin",
                    "name": "Admin"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "cgt84745@omeie.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "cil78131@nezid.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "cleung@imron.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "dasleben7@gmail.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-admin",
                    "name": "Admin"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "david.hc.chen@deltaww.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "dbz46281@xcoxc.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "ddd61742@nezid.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "diro.fan@gmail.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": false,
                  "username": ""
                },
                {
                  "email": "diro@vivotek.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-admin",
                    "name": "Admin"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "dnb82636@romog.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": false,
                  "username": ""
                },
                {
                  "email": "emu75693@nezid.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "eyc78138@omeie.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-admin",
                    "name": "Admin"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "ffl70134@omeie.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-admin",
                    "name": "Admin"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "fkq52263@omeie.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "fud05571@zslsz.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": false,
                  "username": ""
                },
                {
                  "email": "hhu89693@omeie.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "ibs35295@zslsz.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-admin",
                    "name": "Admin"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "irene.yl.wang@vivotek.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "isb55557@omeie.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "iverson.hong@deltaww.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "iwj86568@zslsz.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-admin",
                    "name": "Admin"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "izu25867@zslsz.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "jan.je.lee@vivotek.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "d6ejgg92laebqttm6730",
                    "name": "test-system"
                  },
                  "onBoard": true,
                  "username": "Jiaen Jan"
                },
                {
                  "email": "jason.lu@vivotek.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-owner",
                    "name": "Owner"
                  },
                  "onBoard": true,
                  "username": "☄️☄️☄️☄️☄️☄️☄️☄️☄️☄️☄️☄️☄️☄️☄️☄️☄️☄️☄️"
                },
                {
                  "email": "jkw09346@vogco.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": false,
                  "username": ""
                },
                {
                  "email": "jmz33217@omeie.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": false,
                  "username": ""
                },
                {
                  "email": "joycelan1124+1@gmail.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-admin",
                    "name": "Admin"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "joycelan1124@gmail.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-admin",
                    "name": "Admin"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "junghunglu01@gmail.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "juofan.you@vivotek.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-admin",
                    "name": "Admin"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "jzk80586@vogco.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": false,
                  "username": ""
                },
                {
                  "email": "kelvin.cc.lu@vivotek.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-admin",
                    "name": "Admin"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "leszek.tomanek@gmail.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-admin",
                    "name": "Admin"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "letscott@dsitip.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": "@@"
                },
                {
                  "email": "lvy52155@vogco.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": false,
                  "username": ""
                },
                {
                  "email": "mark.th.chen@deltaww.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "mei-yun.hsu@vivotek.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "mgz69466@nezid.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "mjz71731@nezid.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "nfb08691@romog.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "nvw73387@toaik.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": false,
                  "username": ""
                },
                {
                  "email": "peter.hm.chiu@vivotek.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "pfp99804@nezid.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "pom42126@vogco.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "pwd7206d4@inohm.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": false,
                  "username": ""
                },
                {
                  "email": "qed90444@nezid.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-admin",
                    "name": "Admin"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "qik66776@nezid.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": false,
                  "username": ""
                },
                {
                  "email": "riq45334@romog.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "rxj79497@zbock.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-admin",
                    "name": "Admin"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "santonio.urias@flyovertrees.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "saveji2384@dacgu.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": false,
                  "username": ""
                },
                {
                  "email": "scott221@dropmeon.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "d61eu8o87qv9umqu019g",
                    "name": "dd"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "sovowe5414@centerf.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": false,
                  "username": ""
                },
                {
                  "email": "ss910316+158@gmail.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "ssccoot@dispostable.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "d60quqto9mfovo66c9c0",
                    "name": "PK Org Test"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "sunny.yy.jiang@vivotek.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-admin",
                    "name": "Admin"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "testaaa@bb.cc",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": "testaaaasdasfadddddddwefqwetooooooooooooooolongggggggggggggggggggggggggggggghelllllllllllllllllllllllllllllpopopoopopopopqowpeqq"
                },
                {
                  "email": "testcc@ewd.oco",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "testew2@vivotek.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "tiy08952@nezid.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "txw72683@zslsz.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "ucu88636@zslsz.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "ulj60640@zslsz.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": false,
                  "username": ""
                },
                {
                  "email": "vfp38120@nezid.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-admin",
                    "name": "Admin"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "vortex-ecosys+openapi1@outlook.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-admin",
                    "name": "Admin"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "vortex-ecosys+openapi2@outlook.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "walter.mc.wu@gmail.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "ybk84108@cdfaq.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "yha58223@toaik.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": "joyce.invite"
                },
                {
                  "email": "yhattm+role20250203@gmail.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "zieleznym@poczta.onet.pl",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-admin",
                    "name": "Admin"
                  },
                  "onBoard": true,
                  "username": ""
                },
                {
                  "email": "zoc78870@dcobe.com",
                  "organizationID": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "state": "ACTIVE",
                  "role": {
                    "id": "role-org-member",
                    "name": "Member"
                  },
                  "onBoard": false,
                  "username": ""
                }
              ]
            }
          }
        }
        """.trimIndent()

        val LIST_SI_OF_ORGANIZATION_JSON = """
        {
          "data": {
            "listSIOfOrganization": {
              "items": [
                {
                  "companyID": 166,
                  "companyName": "VIVOTEK HQ (Licenses)",
                  "phoneNumber": "",
                  "email": "vortex.license@vivotek.com",
                  "enableRemoteAccess": true,
                  "autoSendSystemEvent": true
                }
              ]
            }
          }
        }
        """.trimIndent()

        val QUERY_ARCHIVES_JSON = """
        {
          "data": {
            "queryArchiveV2": {
              "items": [
                {
                  "thingName": "0002D1987F0A-1717738593191",
                  "createdAt": "2024-10-25T05:23:44Z",
                  "filename": "Archive_20241025_130341",
                  "creatorNickname": "jason.lu@vivotek.com",
                  "creatorEmail": "jason.lu@vivotek.com",
                  "startAt": "2024-10-25T05:03:40Z",
                  "endAt": "2024-10-25T05:08:44Z",
                  "owner": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "status": "MP4_READY",
                  "videoLength": 303,
                  "videoSize": 0,
                  "taskArn": null,
                  "id": null,
                  "updatedAt": "",
                  "derivant": "none",
                  "cloudSize": 0,
                  "sharedLink": {
                    "id": "YXJjaGl2ZV8wMDAyRDE5ODdGMEEtMTcxNzczODU5MzE5MV8yMDI0LTEwLTI1VDA1OjIzOjQ0Wg",
                    "enabled": true,
                    "password": null,
                    "expireTime": null,
                    "url": "https://portal.dev.vortexcloud.com/share/YXJjaGl2ZV8wMDAyRDE5ODdGMEEtMTcxNzczODU5MzE5MV8yMDI0LTEwLTI1VDA1OjIzOjQ0Wg",
                    "enableDownload": null
                  }
                },
                {
                  "thingName": "0002D1987F0A-1717738593191",
                  "createdAt": "2024-10-30T04:04:21Z",
                  "filename": "Archive_20241030_115917",
                  "creatorNickname": "jason.lu@vivotek.com",
                  "creatorEmail": "jason.lu@vivotek.com",
                  "startAt": "2024-10-30T03:59:16Z",
                  "endAt": "2024-10-30T04:04:20Z",
                  "owner": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "status": "HLS_READY",
                  "videoLength": 304,
                  "videoSize": 0,
                  "taskArn": null,
                  "id": null,
                  "updatedAt": "",
                  "derivant": "none",
                  "cloudSize": 0,
                  "sharedLink": {
                    "id": "",
                    "enabled": false,
                    "password": null,
                    "expireTime": null,
                    "url": null,
                    "enableDownload": null
                  }
                },
                {
                  "thingName": "0002D1987F0A-1717738593191",
                  "createdAt": "2024-10-30T04:07:46Z",
                  "filename": "Archive_20241030_120241",
                  "creatorNickname": "jason.lu@vivotek.com",
                  "creatorEmail": "jason.lu@vivotek.com",
                  "startAt": "2024-10-30T04:02:40Z",
                  "endAt": "2024-10-30T04:07:43Z",
                  "owner": "6d179369-0e0b-48e7-8024-882c925c057c",
                  "status": "MP4_READY",
                  "videoLength": 304,
                  "videoSize": 0,
                  "taskArn": null,
                  "id": null,
                  "updatedAt": "",
                  "derivant": "none",
                  "cloudSize": 0,
                  "sharedLink": {
                    "id": "",
                    "enabled": false,
                    "password": null,
                    "expireTime": null,
                    "url": null,
                    "enableDownload": null
                  }
                }
              ]
            }
          }
        }
        """.trimIndent()
    }
}