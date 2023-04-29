/*    */ package mzm.gsp.singlebattle;
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
/*    */ public class SNewGuyTotalInfoBro
/*    */   extends __SNewGuyTotalInfoBro__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12621606;
/*    */   public long roleid;
/*    */   public int campid;
/*    */   public RoleTotalInfo roletotalinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12621606;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SNewGuyTotalInfoBro()
/*    */   {
/* 35 */     this.roletotalinfo = new RoleTotalInfo();
/*    */   }
/*    */   
/*    */   public SNewGuyTotalInfoBro(long _roleid_, int _campid_, RoleTotalInfo _roletotalinfo_) {
/* 39 */     this.roleid = _roleid_;
/* 40 */     this.campid = _campid_;
/* 41 */     this.roletotalinfo = _roletotalinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     if (!this.roletotalinfo._validator_()) return false;
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.roleid);
/* 51 */     _os_.marshal(this.campid);
/* 52 */     _os_.marshal(this.roletotalinfo);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.roleid = _os_.unmarshal_long();
/* 58 */     this.campid = _os_.unmarshal_int();
/* 59 */     this.roletotalinfo.unmarshal(_os_);
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SNewGuyTotalInfoBro)) {
/* 69 */       SNewGuyTotalInfoBro _o_ = (SNewGuyTotalInfoBro)_o1_;
/* 70 */       if (this.roleid != _o_.roleid) return false;
/* 71 */       if (this.campid != _o_.campid) return false;
/* 72 */       if (!this.roletotalinfo.equals(_o_.roletotalinfo)) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += (int)this.roleid;
/* 81 */     _h_ += this.campid;
/* 82 */     _h_ += this.roletotalinfo.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.roleid).append(",");
/* 90 */     _sb_.append(this.campid).append(",");
/* 91 */     _sb_.append(this.roletotalinfo).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\SNewGuyTotalInfoBro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */