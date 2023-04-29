/*    */ package mzm.gsp.chinesevalentine;
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
/*    */ public class SChineseValentineRound
/*    */   extends __SChineseValentineRound__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12622090;
/*    */   public int roundnumber;
/*    */   public HashMap<Long, Integer> highlightmap;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12622090;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SChineseValentineRound()
/*    */   {
/* 34 */     this.roundnumber = 1;
/* 35 */     this.highlightmap = new HashMap();
/*    */   }
/*    */   
/*    */   public SChineseValentineRound(int _roundnumber_, HashMap<Long, Integer> _highlightmap_) {
/* 39 */     this.roundnumber = _roundnumber_;
/* 40 */     this.highlightmap = _highlightmap_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.roundnumber);
/* 49 */     _os_.compact_uint32(this.highlightmap.size());
/* 50 */     for (Map.Entry<Long, Integer> _e_ : this.highlightmap.entrySet()) {
/* 51 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/* 52 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.roundnumber = _os_.unmarshal_int();
/* 59 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 61 */       long _k_ = _os_.unmarshal_long();
/*    */       
/* 63 */       int _v_ = _os_.unmarshal_int();
/* 64 */       this.highlightmap.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof SChineseValentineRound)) {
/* 75 */       SChineseValentineRound _o_ = (SChineseValentineRound)_o1_;
/* 76 */       if (this.roundnumber != _o_.roundnumber) return false;
/* 77 */       if (!this.highlightmap.equals(_o_.highlightmap)) return false;
/* 78 */       return true;
/*    */     }
/* 80 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 84 */     int _h_ = 0;
/* 85 */     _h_ += this.roundnumber;
/* 86 */     _h_ += this.highlightmap.hashCode();
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append(this.roundnumber).append(",");
/* 94 */     _sb_.append(this.highlightmap).append(",");
/* 95 */     _sb_.append(")");
/* 96 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chinesevalentine\SChineseValentineRound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */