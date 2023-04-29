/*    */ package mzm.gsp.superequipment;
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
/*    */ 
/*    */ 
/*    */ public class SSynWuShiInfo
/*    */   extends __SSynWuShiInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12618777;
/*    */   public ArrayList<WuShiInfo> wushiinfos;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12618777;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSynWuShiInfo()
/*    */   {
/* 33 */     this.wushiinfos = new ArrayList();
/*    */   }
/*    */   
/*    */   public SSynWuShiInfo(ArrayList<WuShiInfo> _wushiinfos_) {
/* 37 */     this.wushiinfos = _wushiinfos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     for (WuShiInfo _v_ : this.wushiinfos)
/* 42 */       if (!_v_._validator_()) return false;
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.compact_uint32(this.wushiinfos.size());
/* 48 */     for (WuShiInfo _v_ : this.wushiinfos) {
/* 49 */       _os_.marshal(_v_);
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 56 */       WuShiInfo _v_ = new WuShiInfo();
/* 57 */       _v_.unmarshal(_os_);
/* 58 */       this.wushiinfos.add(_v_);
/*    */     }
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SSynWuShiInfo)) {
/* 69 */       SSynWuShiInfo _o_ = (SSynWuShiInfo)_o1_;
/* 70 */       if (!this.wushiinfos.equals(_o_.wushiinfos)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.wushiinfos.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.wushiinfos).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\SSynWuShiInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */