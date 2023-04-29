/*    */ package mzm.gsp.item;
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
/*    */ public class SGiveItemCountChangeInfo
/*    */   extends __SGiveItemCountChangeInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584726;
/*    */   public long roleid;
/*    */   public int count;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12584726;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SGiveItemCountChangeInfo() {}
/*    */   
/*    */ 
/*    */   public SGiveItemCountChangeInfo(long _roleid_, int _count_)
/*    */   {
/* 35 */     this.roleid = _roleid_;
/* 36 */     this.count = _count_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.roleid);
/* 45 */     _os_.marshal(this.count);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.roleid = _os_.unmarshal_long();
/* 51 */     this.count = _os_.unmarshal_int();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SGiveItemCountChangeInfo)) {
/* 61 */       SGiveItemCountChangeInfo _o_ = (SGiveItemCountChangeInfo)_o1_;
/* 62 */       if (this.roleid != _o_.roleid) return false;
/* 63 */       if (this.count != _o_.count) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += (int)this.roleid;
/* 72 */     _h_ += this.count;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.roleid).append(",");
/* 80 */     _sb_.append(this.count).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SGiveItemCountChangeInfo _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.count - _o_.count;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SGiveItemCountChangeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */