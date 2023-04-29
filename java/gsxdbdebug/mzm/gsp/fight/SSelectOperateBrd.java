/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSelectOperateBrd
/*    */   extends __SSelectOperateBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12594180;
/*    */   public int fighterid;
/*    */   public int op_type;
/*    */   public Octets content;
/*    */   public int auto;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12594180;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSelectOperateBrd()
/*    */   {
/* 36 */     this.content = new Octets();
/*    */   }
/*    */   
/*    */   public SSelectOperateBrd(int _fighterid_, int _op_type_, Octets _content_, int _auto_) {
/* 40 */     this.fighterid = _fighterid_;
/* 41 */     this.op_type = _op_type_;
/* 42 */     this.content = _content_;
/* 43 */     this.auto = _auto_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.fighterid);
/* 52 */     _os_.marshal(this.op_type);
/* 53 */     _os_.marshal(this.content);
/* 54 */     _os_.marshal(this.auto);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.fighterid = _os_.unmarshal_int();
/* 60 */     this.op_type = _os_.unmarshal_int();
/* 61 */     this.content = _os_.unmarshal_Octets();
/* 62 */     this.auto = _os_.unmarshal_int();
/* 63 */     if (!_validator_()) {
/* 64 */       throw new VerifyError("validator failed");
/*    */     }
/* 66 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 70 */     if (_o1_ == this) return true;
/* 71 */     if ((_o1_ instanceof SSelectOperateBrd)) {
/* 72 */       SSelectOperateBrd _o_ = (SSelectOperateBrd)_o1_;
/* 73 */       if (this.fighterid != _o_.fighterid) return false;
/* 74 */       if (this.op_type != _o_.op_type) return false;
/* 75 */       if (!this.content.equals(_o_.content)) return false;
/* 76 */       if (this.auto != _o_.auto) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.fighterid;
/* 85 */     _h_ += this.op_type;
/* 86 */     _h_ += this.content.hashCode();
/* 87 */     _h_ += this.auto;
/* 88 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 92 */     StringBuilder _sb_ = new StringBuilder();
/* 93 */     _sb_.append("(");
/* 94 */     _sb_.append(this.fighterid).append(",");
/* 95 */     _sb_.append(this.op_type).append(",");
/* 96 */     _sb_.append("B").append(this.content.size()).append(",");
/* 97 */     _sb_.append(this.auto).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\SSelectOperateBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */