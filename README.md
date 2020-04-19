Assumptions :

1) Once a invalid reason is received no further check will be done
	Validation priority 
	Email > Phone > Date > PNR > Cabin
2) Localization not needed
3) Error and Processed File format will be same if not provided by user
4) Always first line in CSV file will contain headers
5) Always all 10 fields will be received
6) Input and Output File location will be same with name as (inputFileName)_invalid.(format) and (inputFileName)_valid.(format)
7) Date Format YYYY-MM-DD
8) File will created with header only even if no content available to add in _valid/_invalid files


Dependencies :
junit-3.8.1.zip add in the ZIP file for dependency (rename this to .jar as .jar is not allowed by google to send over emails). Or run Maven command (mvn install --DskipTest) to download it. Or same can be download from https://github.com/gauravjeswani/ticket-upgrader git repository.


Observation with Input data Given In PDF :

For Record-
Kalyani ,Ben,A1B2C3,M,2019-04-30,1,2019-05-21,kben@zzz.com,9876543213,Premium Economy

Record Input Data Is Invalid for Dates, while it is displayed in expected record with different value



Test Data (testinf method in TicketUpgraderTest) : (Check console to get the Input/Output file Path)

TicketUpgrader\src\test\resources\csv\Input.csv : Same as Input provided in PDF (testWithInputFileLocation)
TicketUpgrader\src\test\resources\csv\Input_1.csv : Same as Input needed for Expected Out in PDF (As Input and Expected results data is not in sync) (testWithInputFileLocationAndName)
TicketUpgrader\src\test\resources\csv\Input_2.csv : All Valid Data (testWithInputFileName)
TicketUpgrader\src\test\resources\csv\Input_3.csv : All Invalid Data with all validation failed  (testWithInputFilePath)
TicketUpgrader\src\test\resources\txt\Input.txt : Invalid file format (testWithInputFilePathAndWrongFormat)
"C://test//csv//file.csv" : Test with missing input file (testWithMissingInputFile)

AppTest.java : Main method to pass the absolute path of file to process.