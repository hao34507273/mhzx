/*    */ package mzm.gsp.partner;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSynPartnerYuanShen
/*    */   extends __SSynPartnerYuanShen__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588056;
/*    */   public int partnerid;
/*    */   public int yuanlv;
/*    */   public ArrayList<Integer> levels;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12588056;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSynPartnerYuanShen()
/*    */   {
/* 35 */     this.levels = new ArrayList();
/*    */   }
/*    */   
/*    */   public SSynPartnerYuanShen(int _partnerid_, int _yuanlv_, ArrayList<Integer> _levels_) {
/* 39 */     this.partnerid = _partnerid_;
/* 40 */     this.yuanlv = _yuanlv_;
/* 41 */     this.levels = _levels_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.partnerid);
/* 50 */     _os_.marshal(this.yuanlv);
/* 51 */     _os_.compact_uint32(this.levels.size());
/* 52 */     for (Integer _v_ : this.levels) {
/* 53 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.partnerid = _os_.unmarshal_int();
/* 60 */     this.yuanlv = _os_.unmarshal_int();
/* 61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 63 */       int _v_ = _os_.unmarshal_int();
/* 64 */       this.levels.add(Integer.valueOf(_v_));
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof SSynPartnerYuanShen)) {
/* 75 */       SSynPartnerYuanShen _o_ = (SSynPartnerYuanShen)_o1_;
/* 76 */       if (this.partnerid != _o_.partnerid) return false;
/* 77 */       if (this.yuanlv != _o_.yuanlv) return false;
/* 78 */       if (!this.levels.equals(_o_.levels)) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.partnerid;
/* 87 */     _h_ += this.yuanlv;
/* 88 */     _h_ += this.levels.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.partnerid).append(",");
/* 96 */     _sb_.append(this.yuanlv).append(",");
/* 97 */     _sb_.append(this.levels).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\SSynPartnerYuanShen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */