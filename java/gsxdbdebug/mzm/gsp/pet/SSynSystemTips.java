/*    */ package mzm.gsp.pet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSynSystemTips
/*    */   extends __SSynSystemTips__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590639;
/*    */   public static final int TILI_APT = 0;
/*    */   public static final int MAG_APT = 1;
/*    */   public static final int ATK_APT = 2;
/*    */   public static final int DEF_APT = 3;
/*    */   public static final int SPEED_APT = 4;
/*    */   public HashMap<Integer, Integer> extramap;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590639;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSynSystemTips()
/*    */   {
/* 39 */     this.extramap = new HashMap();
/*    */   }
/*    */   
/*    */   public SSynSystemTips(HashMap<Integer, Integer> _extramap_) {
/* 43 */     this.extramap = _extramap_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.compact_uint32(this.extramap.size());
/* 52 */     for (Map.Entry<Integer, Integer> _e_ : this.extramap.entrySet()) {
/* 53 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 54 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 60 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 62 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 64 */       int _v_ = _os_.unmarshal_int();
/* 65 */       this.extramap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 67 */     if (!_validator_()) {
/* 68 */       throw new VerifyError("validator failed");
/*    */     }
/* 70 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 74 */     if (_o1_ == this) return true;
/* 75 */     if ((_o1_ instanceof SSynSystemTips)) {
/* 76 */       SSynSystemTips _o_ = (SSynSystemTips)_o1_;
/* 77 */       if (!this.extramap.equals(_o_.extramap)) return false;
/* 78 */       return true;
/*    */     }
/* 80 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 84 */     int _h_ = 0;
/* 85 */     _h_ += this.extramap.hashCode();
/* 86 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 90 */     StringBuilder _sb_ = new StringBuilder();
/* 91 */     _sb_.append("(");
/* 92 */     _sb_.append(this.extramap).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SSynSystemTips.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */