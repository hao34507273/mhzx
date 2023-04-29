/*    */ package mzm.gsp.yuanbao;
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
/*    */ public class SSyncYuanbaoChange
/*    */   extends __SSyncYuanbaoChange__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12586241;
/*    */   public static final int YUANBAO_AWARD = 0;
/*    */   public static final int YUANBAO_BUY = 1;
/*    */   public static final int TOTAL_BUY_YUANBAO = 2;
/*    */   public HashMap<Integer, Long> yuanbaochangemap;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12586241;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSyncYuanbaoChange()
/*    */   {
/* 37 */     this.yuanbaochangemap = new HashMap();
/*    */   }
/*    */   
/*    */   public SSyncYuanbaoChange(HashMap<Integer, Long> _yuanbaochangemap_) {
/* 41 */     this.yuanbaochangemap = _yuanbaochangemap_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.compact_uint32(this.yuanbaochangemap.size());
/* 50 */     for (Map.Entry<Integer, Long> _e_ : this.yuanbaochangemap.entrySet()) {
/* 51 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 52 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 60 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 62 */       long _v_ = _os_.unmarshal_long();
/* 63 */       this.yuanbaochangemap.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*    */     }
/* 65 */     if (!_validator_()) {
/* 66 */       throw new VerifyError("validator failed");
/*    */     }
/* 68 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 72 */     if (_o1_ == this) return true;
/* 73 */     if ((_o1_ instanceof SSyncYuanbaoChange)) {
/* 74 */       SSyncYuanbaoChange _o_ = (SSyncYuanbaoChange)_o1_;
/* 75 */       if (!this.yuanbaochangemap.equals(_o_.yuanbaochangemap)) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.yuanbaochangemap.hashCode();
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.yuanbaochangemap).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\yuanbao\SSyncYuanbaoChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */