CREATE TYPE projectStatus AS ENUM ('IN_PROGRESS','COMPLETED','CANCELLED');
CREATE TYPE componentType AS ENUM ('Material','Labor');

CREATE TABLE clients
(
    id             SERIAL PRIMARY KEY,
    name           VARCHAR(40) NOT NULL,
    address        text        NULL,
    phone          varchar(20) NOT NULL,
    isProfessional boolean     NOT NULL,
    isDeleted      boolean default false
);



CREATE Table projects
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR(40),
    profitMargin float,
    totalCost    float,
    status       projectStatus,
    client_id    int REFERENCES clients (id),
    isDeleted    boolean default false
);

CREATE TABLE quotes
(
    id              SERIAL PRIMARY KEY,
    issueDate       DATE    default now(),
    EstimatedAmount float,
    validityDate    Date NULL,
    isAccepted      Boolean default false,
    project_id      int REFERENCES projects (id),
    isDeleted       boolean default false
);

CREATE TABLE components
(
    id         SERIAL PRIMARY KEY,
    name       varchar(30)   not null,
    type       componentType not null,
    project_id int REFERENCES projects (id),
    isDeleted  boolean default false
);

CREATE TABLE materials
(
    transportCost      float null,
    qualityCoefficient float not null,
    unitCost           float not null,
    quantity           int   not null
) inherits (components);

CREATE TABLE labors
(
    hourlyRate         float null,
    hoursWorked        float null,
    workerProductivity float null
) inherits (components);


-- Insert fake clients
INSERT INTO clients (name, address, phone, isProfessional)
VALUES ('John Doe', '123 Main St, Anytown', '555-1234', false),
       ('Jane Smith', '456 Elm St, Othertown', '555-5678', true),
       ('Acme Corporation', '789 Oak Rd, Biztown', '555-9012', true),
       ('Bob Johnson', '321 Pine Ave, Somewhereville', '555-3456', false),
       ('Sarah Williams', '654 Birch Ln, Anothercity', '555-7890', false);

-- Insert fake projects
INSERT INTO projects (name, profitMargin, totalCost, status, client_id)
VALUES ('Kitchen Renovation', 0.15, 10000.00, 'IN_PROGRESS', 1),
       ('Office Remodel', 0.20, 25000.00, 'COMPLETED', 2),
       ('New Store Fitout', 0.18, 50000.00, 'IN_PROGRESS', 3),
       ('Bathroom Upgrade', 0.12, 8000.00, 'IN_PROGRESS', 4),
       ('Home Extension', 0.10, 30000.00, 'CANCELLED', 5);

-- Insert fake quotes
INSERT INTO quotes (issueDate, EstimatedAmount, validityDate, isAccepted, project_id)
VALUES ('2023-09-01', 90.6, '2023-10-01', true, 1),
       ('2023-08-15', 90.6, '2023-09-15', true, 2),
       ('2023-09-10', 90.6, '2023-10-10', false, 3),
       ('2023-09-05', 90.6, '2023-10-05', true, 4),
       ('2023-08-20', 90.6, '2023-09-20', false, 5);

-- Insert fake materials
INSERT INTO materials (name, unitCost, quantity, type, project_id, transportCost, qualityCoefficient)
VALUES ('Granite Countertop', 300.00, 2, 'Material', 1, 150.00, 1.2),
       ('Kitchen Cabinets', 200.00, 5, 'Material', 1, 100.00, 1.0),
       ('Office Desk', 250.00, 10, 'Material', 2, 200.00, 1.1),
       ('Floor Tiles', 15.00, 1000, 'Material', 3, 300.00, 1.0),
       ('Bathroom Vanity', 400.00, 1, 'Material', 4, 50.00, 1.3);

-- Insert fake labor
INSERT INTO labors (name, type, project_id, hourlyRate, hoursWorked, workerProductivity)
VALUES ('Kitchen Installation', 'Labor', 1, 25.00, 40.00, 1.0),
       ('Office Painting', 'Labor', 2, 20.00, 60.00, 1.1),
       ('Electrical Work', 'Labor', 3, 30.00, 80.00, 1.2),
       ('Plumbing', 'Labor', 4, 28.00, 20.00, 1.0),
       ('General Contracting', 'Labor', 5, 35.00, 100.00, 1.1);