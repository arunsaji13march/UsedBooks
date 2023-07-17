import { Injectable } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
@Injectable({
  providedIn: 'root'
})
export class NotificationService {
  constructor(private toastr: ToastrService) { }
  showSuccess(message: string, title: string ){
    this.toastr.success(message, title,{
      timeOut:1500
    })
}
showError(message: string | undefined, title: string | undefined){
    this.toastr.error(message, title,{
      timeOut:2000
    })
}
showInfo(message: string | undefined, title: string | undefined){
    this.toastr.info(message, title)
}
showWarning(message: string | undefined, title: string | undefined){
    this.toastr.warning(message, title)
}
}