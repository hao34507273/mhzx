/*    */ package grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class DataBetweenGameAndGrcRes implements Marshal
/*    */ {
/*    */   public int retcode;
/*    */   public Octets info;
/*    */   public int reserved1;
/*    */   public int reserved2;
/*    */   
/*    */   public DataBetweenGameAndGrcRes()
/*    */   {
/* 17 */     this.retcode = 9;
/* 18 */     this.info = new Octets();
/* 19 */     this.reserved1 = 0;
/* 20 */     this.reserved2 = 0;
/*    */   }
/*    */   
/*    */   public DataBetweenGameAndGrcRes(int _retcode_, Octets _info_, int _reserved1_, int _reserved2_) {
/* 24 */     this.retcode = _retcode_;
/* 25 */     this.info = _info_;
/* 26 */     this.reserved1 = _reserved1_;
/* 27 */     this.reserved2 = _reserved2_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 35 */     _os_.marshal(this.retcode);
/* 36 */     _os_.marshal(this.info);
/* 37 */     _os_.marshal(this.reserved1);
/* 38 */     _os_.marshal(this.reserved2);
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 43 */     this.retcode = _os_.unmarshal_int();
/* 44 */     this.info = _os_.unmarshal_Octets();
/* 45 */     this.reserved1 = _os_.unmarshal_int();
/* 46 */     this.reserved2 = _os_.unmarshal_int();
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 51 */     if (_o1_ == this) return true;
/* 52 */     if ((_o1_ instanceof DataBetweenGameAndGrcRes)) {
/* 53 */       DataBetweenGameAndGrcRes _o_ = (DataBetweenGameAndGrcRes)_o1_;
/* 54 */       if (this.retcode != _o_.retcode) return false;
/* 55 */       if (!this.info.equals(_o_.info)) return false;
/* 56 */       if (this.reserved1 != _o_.reserved1) return false;
/* 57 */       if (this.reserved2 != _o_.reserved2) return false;
/* 58 */       return true;
/*    */     }
/* 60 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 64 */     int _h_ = 0;
/* 65 */     _h_ += this.retcode;
/* 66 */     _h_ += this.info.hashCode();
/* 67 */     _h_ += this.reserved1;
/* 68 */     _h_ += this.reserved2;
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.retcode).append(",");
/* 76 */     _sb_.append("B").append(this.info.size()).append(",");
/* 77 */     _sb_.append(this.reserved1).append(",");
/* 78 */     _sb_.append(this.reserved2).append(",");
/* 79 */     _sb_.append(")");
/* 80 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\DataBetweenGameAndGrcRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */