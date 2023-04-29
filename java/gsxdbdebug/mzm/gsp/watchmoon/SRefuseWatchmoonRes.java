/*    */ package mzm.gsp.watchmoon;
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
/*    */ public class SRefuseWatchmoonRes
/*    */   extends __SRefuseWatchmoonRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600845;
/*    */   public long roleid2;
/*    */   public String name2;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12600845;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SRefuseWatchmoonRes()
/*    */   {
/* 34 */     this.name2 = "";
/*    */   }
/*    */   
/*    */   public SRefuseWatchmoonRes(long _roleid2_, String _name2_) {
/* 38 */     this.roleid2 = _roleid2_;
/* 39 */     this.name2 = _name2_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.roleid2);
/* 48 */     _os_.marshal(this.name2, "UTF-16LE");
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.roleid2 = _os_.unmarshal_long();
/* 54 */     this.name2 = _os_.unmarshal_String("UTF-16LE");
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SRefuseWatchmoonRes)) {
/* 64 */       SRefuseWatchmoonRes _o_ = (SRefuseWatchmoonRes)_o1_;
/* 65 */       if (this.roleid2 != _o_.roleid2) return false;
/* 66 */       if (!this.name2.equals(_o_.name2)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.roleid2;
/* 75 */     _h_ += this.name2.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.roleid2).append(",");
/* 83 */     _sb_.append("T").append(this.name2.length()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\watchmoon\SRefuseWatchmoonRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */