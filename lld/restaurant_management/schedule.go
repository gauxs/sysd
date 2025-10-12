package restaurantmanagement

type Slot struct {
	startTime string
	endTime   string
}

type Schedule struct {
	ID    string
	Slots []Slot
}
