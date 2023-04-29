/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SGetPointRaceDataSuccess
/*    */   extends __SGetPointRaceDataSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617023;
/*    */   public PointRaceData point_race_data;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12617023;
/*    */   }
/*    */   
/*    */ 
/*    */   public SGetPointRaceDataSuccess()
/*    */   {
/* 33 */     this.point_race_data = new PointRaceData();
/*    */   }
/*    */   
/*    */   public SGetPointRaceDataSuccess(PointRaceData _point_race_data_) {
/* 37 */     this.point_race_data = _point_race_data_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.point_race_data._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.point_race_data);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.point_race_data.unmarshal(_os_);
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SGetPointRaceDataSuccess)) {
/* 61 */       SGetPointRaceDataSuccess _o_ = (SGetPointRaceDataSuccess)_o1_;
/* 62 */       if (!this.point_race_data.equals(_o_.point_race_data)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.point_race_data.hashCode();
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.point_race_data).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SGetPointRaceDataSuccess _o_) {
/* 83 */     if (_o_ == this) return 0;
/* 84 */     int _c_ = 0;
/* 85 */     _c_ = this.point_race_data.compareTo(_o_.point_race_data);
/* 86 */     if (0 != _c_) return _c_;
/* 87 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SGetPointRaceDataSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */