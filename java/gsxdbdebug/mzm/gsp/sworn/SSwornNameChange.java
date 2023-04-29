/*    */ package mzm.gsp.sworn;
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
/*    */ public class SSwornNameChange
/*    */   extends __SSwornNameChange__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12597799;
/*    */   public long swornid;
/*    */   public String name1;
/*    */   public String name2;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12597799;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSwornNameChange()
/*    */   {
/* 35 */     this.name1 = "";
/* 36 */     this.name2 = "";
/*    */   }
/*    */   
/*    */   public SSwornNameChange(long _swornid_, String _name1_, String _name2_) {
/* 40 */     this.swornid = _swornid_;
/* 41 */     this.name1 = _name1_;
/* 42 */     this.name2 = _name2_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.swornid);
/* 51 */     _os_.marshal(this.name1, "UTF-16LE");
/* 52 */     _os_.marshal(this.name2, "UTF-16LE");
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.swornid = _os_.unmarshal_long();
/* 58 */     this.name1 = _os_.unmarshal_String("UTF-16LE");
/* 59 */     this.name2 = _os_.unmarshal_String("UTF-16LE");
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SSwornNameChange)) {
/* 69 */       SSwornNameChange _o_ = (SSwornNameChange)_o1_;
/* 70 */       if (this.swornid != _o_.swornid) return false;
/* 71 */       if (!this.name1.equals(_o_.name1)) return false;
/* 72 */       if (!this.name2.equals(_o_.name2)) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += (int)this.swornid;
/* 81 */     _h_ += this.name1.hashCode();
/* 82 */     _h_ += this.name2.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.swornid).append(",");
/* 90 */     _sb_.append("T").append(this.name1.length()).append(",");
/* 91 */     _sb_.append("T").append(this.name2.length()).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\SSwornNameChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */