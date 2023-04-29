/*    */ package mzm.gsp.countdown;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashSet;
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
/*    */ public class SSynCountDownInfo
/*    */   extends __SSynCountDownInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12606724;
/*    */   public HashSet<Integer> not_get_red_packet_cfg_ids;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12606724;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSynCountDownInfo()
/*    */   {
/* 33 */     this.not_get_red_packet_cfg_ids = new HashSet();
/*    */   }
/*    */   
/*    */   public SSynCountDownInfo(HashSet<Integer> _not_get_red_packet_cfg_ids_) {
/* 37 */     this.not_get_red_packet_cfg_ids = _not_get_red_packet_cfg_ids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.compact_uint32(this.not_get_red_packet_cfg_ids.size());
/* 46 */     for (Integer _v_ : this.not_get_red_packet_cfg_ids) {
/* 47 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 55 */       int _v_ = _os_.unmarshal_int();
/* 56 */       this.not_get_red_packet_cfg_ids.add(Integer.valueOf(_v_));
/*    */     }
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SSynCountDownInfo)) {
/* 67 */       SSynCountDownInfo _o_ = (SSynCountDownInfo)_o1_;
/* 68 */       if (!this.not_get_red_packet_cfg_ids.equals(_o_.not_get_red_packet_cfg_ids)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.not_get_red_packet_cfg_ids.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.not_get_red_packet_cfg_ids).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\countdown\SSynCountDownInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */