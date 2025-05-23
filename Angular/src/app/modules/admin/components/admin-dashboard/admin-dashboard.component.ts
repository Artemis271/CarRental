import { Component } from '@angular/core';
import { AdminService } from '../../services/admin.service';
import { NzMessageService } from 'ng-zorro-antd/message';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.scss']
})
export class AdminDashboardComponent {

  cars: any = [];

  constructor(private adminService: AdminService,
              private message: NzMessageService) {
    this.getAllCars();
  }

  getAllCars() {
    this.adminService.getAlCars().subscribe((res) => {
      console.log(res);
      res.forEach(element => {
        element.processedImg = 'data:image/jpeg;base64,' + element.returnedImage;
        this.cars.push(element);
      });
    })
  }

  deleteCar(id: number) {
    this.cars = [];
    this.adminService.deleteCar(id).subscribe((res) => {
      this.message.success("Car deleted successfully", { nzDuration: 5000 });
      this.getAllCars();
    })
  }

}
