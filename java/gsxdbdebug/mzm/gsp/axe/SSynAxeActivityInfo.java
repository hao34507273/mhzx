/*    */ package mzm.gsp.axe;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSynAxeActivityInfo
/*    */   extends __SSynAxeActivityInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12614918;
/*    */   public HashMap<Integer, Integer> activity_infos;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12614918;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSynAxeActivityInfo()
/*    */   {
/* 33 */     this.activity_infos = new HashMap();
/*    */   }
/*    */   
/*    */   public SSynAxeActivityInfo(HashMap<Integer, Integer> _activity_infos_) {
/* 37 */     this.activity_infos = _activity_infos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.compact_uint32(this.activity_infos.size());
/* 46 */     for (Map.Entry<Integer, Integer> _e_ : this.activity_infos.entrySet()) {
/* 47 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 48 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 56 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 58 */       int _v_ = _os_.unmarshal_int();
/* 59 */       this.activity_infos.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof SSynAxeActivityInfo)) {
/* 70 */       SSynAxeActivityInfo _o_ = (SSynAxeActivityInfo)_o1_;
/* 71 */       if (!this.activity_infos.equals(_o_.activity_infos)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.activity_infos.hashCode();
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.activity_infos).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\axe\SSynAxeActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */