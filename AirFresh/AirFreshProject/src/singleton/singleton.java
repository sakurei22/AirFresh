package singleton;

import Service.AsServiceInterface;
import Service.InstallServiceInterface;
import Service.ManageMemberInterface;
import Service.MemberServiceInterface;
import Service.ModelServiceInterface;
import Service.NoticeBbsServiceInterface;
import Service.OrderReviewServiceInterface;
import Service.PurchaseServiceInterface;
import Service.QnaBbsServiceInterface;
import Service.impl.AsService;
import Service.impl.InstallService;
import Service.impl.ManageMemberService;
import Service.impl.MemberService;
import Service.impl.ModelService;
import Service.impl.NoticeBbsService;
import Service.impl.OrderRevService;
import Service.impl.OrderReviewService;
import Service.impl.PurchaseService;
import Service.impl.QnaBbsService;

public class singleton {
	
	private static singleton s = null;
	public MemberServiceInterface ms = null;
	public NoticeBbsServiceInterface nbsi = null;
	public ModelServiceInterface msi = null;
	public PurchaseServiceInterface ps = null;
	public AsServiceInterface asi = null;
	public ManageMemberInterface managerMember = null;
	public InstallServiceInterface is = null;
	public QnaBbsServiceInterface qbs = null;
	public OrderReviewServiceInterface orsi = null;
	
	

	private singleton() {
		ms = new MemberService();
		nbsi = new NoticeBbsService();
		msi = new ModelService();
		ps = new PurchaseService();
		asi = new AsService();
		managerMember = new ManageMemberService();
		is = new InstallService();
		qbs = new QnaBbsService();
		orsi = new OrderReviewService();
		
	}
	
	public static singleton getInstance() {
		if(s == null) {
			s = new singleton();
		}
		return s;
	}


}//end class
