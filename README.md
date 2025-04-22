# Hotel Booking System

A console-based Java application for managing hotel room bookings, including booking, deleting, and viewing reservations.

## Features

- **Room Booking**: Book a room by providing guest ID, name, and selecting a room type (Single Room, Double Room, Suite).
- **Booking Deletion**: Cancel bookings using the guest ID.
- **Booking Summary**: Display all bookings with details like guest ID, name, room type, and room number.
- **Simple Interface**: Command-line interface with a menu-driven system.

## Prerequisites

- Java Development Kit (JDK) 8 or higher

## How to Run

1. Compile the Java file:

   ```bash
   javac HotelBookingSystem.java
   ```
2. Run the application:

   ```bash
   java HotelBookingSystem
   ```

## Usage

1. **Main Menu**:
   - Choose from options: Book a Room, Delete a Booking, View All Bookings, or Exit.
2. **Book a Room**:
   - Enter Guest ID and Guest Name.
   - Select a room type (1: Single Room, 2: Double Room, 3: Suite).
   - Receive a unique room number (e.g., B001).
3. **Delete a Booking**:
   - Enter the Guest ID to cancel the corresponding booking.
4. **View All Bookings**:
   - Displays a table of all bookings with guest details and room information.

## Room Types

- Single Room
- Double Room
- Suite

## Notes

- Guest ID and Name are required and cannot be empty.
- Each booking is assigned a unique room number in the format `Bxxx` (e.g., B001).
- Bookings are stored in memory and cleared when the application exits.
- Invalid inputs (e.g., non-numeric menu choices or invalid room types) are handled with error messages.
