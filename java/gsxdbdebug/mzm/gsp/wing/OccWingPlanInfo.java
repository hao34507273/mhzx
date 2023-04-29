/*    */ package mzm.gsp.wing;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class OccWingPlanInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int occid;
/*    */   public Octets planname;
/*    */   
/*    */   public OccWingPlanInfo()
/*    */   {
/* 13 */     this.planname = new Octets();
/*    */   }
/*    */   
/*    */   public OccWingPlanInfo(int _occid_, Octets _planname_) {
/* 17 */     this.occid = _occid_;
/* 18 */     this.planname = _planname_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 26 */     _os_.marshal(this.occid);
/* 27 */     _os_.marshal(this.planname);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 32 */     this.occid = _os_.unmarshal_int();
/* 33 */     this.planname = _os_.unmarshal_Octets();
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 38 */     if (_o1_ == this) return true;
/* 39 */     if ((_o1_ instanceof OccWingPlanInfo)) {
/* 40 */       OccWingPlanInfo _o_ = (OccWingPlanInfo)_o1_;
/* 41 */       if (this.occid != _o_.occid) return false;
/* 42 */       if (!this.planname.equals(_o_.planname)) return false;
/* 43 */       return true;
/*    */     }
/* 45 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 49 */     int _h_ = 0;
/* 50 */     _h_ += this.occid;
/* 51 */     _h_ += this.planname.hashCode();
/* 52 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 56 */     StringBuilder _sb_ = new StringBuilder();
/* 57 */     _sb_.append("(");
/* 58 */     _sb_.append(this.occid).append(",");
/* 59 */     _sb_.append("B").append(this.planname.size()).append(",");
/* 60 */     _sb_.append(")");
/* 61 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\OccWingPlanInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */