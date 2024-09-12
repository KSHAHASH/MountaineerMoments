package edu.appstate.cs.moments

import java.util.Date

// NOTE: We want to use Strings here, not string resources, since in the
// future we will be allowing users of our app to enter these themselves.
// At that point, it would be impossible to use resources for this.
data class Moment(var title: String, var description: String, var timestamp: Date = Date())