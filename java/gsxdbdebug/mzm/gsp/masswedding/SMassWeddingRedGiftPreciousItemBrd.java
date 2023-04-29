/*    */ package mzm.gsp.masswedding;
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
/*    */ public class SMassWeddingRedGiftPreciousItemBrd
/*    */   extends __SMassWeddingRedGiftPreciousItemBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12604966;
/*    */   public String rolename;
/*    */   public HashMap<Integer, Integer> item2num;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12604966;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SMassWeddingRedGiftPreciousItemBrd()
/*    */   {
/* 34 */     this.rolename = "";
/* 35 */     this.item2num = new HashMap();
/*    */   }
/*    */   
/*    */   public SMassWeddingRedGiftPreciousItemBrd(String _rolename_, HashMap<Integer, Integer> _item2num_) {
/* 39 */     this.rolename = _rolename_;
/* 40 */     this.item2num = _item2num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.rolename, "UTF-16LE");
/* 49 */     _os_.compact_uint32(this.item2num.size());
/* 50 */     for (Map.Entry<Integer, Integer> _e_ : this.item2num.entrySet()) {
/* 51 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 52 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/* 59 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 61 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 63 */       int _v_ = _os_.unmarshal_int();
/* 64 */       this.item2num.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof SMassWeddingRedGiftPreciousItemBrd)) {
/* 75 */       SMassWeddingRedGiftPreciousItemBrd _o_ = (SMassWeddingRedGiftPreciousItemBrd)_o1_;
/* 76 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 77 */       if (!this.item2num.equals(_o_.item2num)) return false;
/* 78 */       return true;
/*    */     }
/* 80 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 84 */     int _h_ = 0;
/* 85 */     _h_ += this.rolename.hashCode();
/* 86 */     _h_ += this.item2num.hashCode();
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 94 */     _sb_.append(this.item2num).append(",");
/* 95 */     _sb_.append(")");
/* 96 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\SMassWeddingRedGiftPreciousItemBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */