/*    */ package mzm.gsp.item;
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
/*    */ 
/*    */ 
/*    */ public class SSiftItemRes
/*    */   extends __SSiftItemRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584735;
/*    */   public int siftcfgid;
/*    */   public ArrayList<Integer> itemlist;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 30 */     return 12584735;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSiftItemRes()
/*    */   {
/* 37 */     this.itemlist = new ArrayList();
/*    */   }
/*    */   
/*    */   public SSiftItemRes(int _siftcfgid_, ArrayList<Integer> _itemlist_) {
/* 41 */     this.siftcfgid = _siftcfgid_;
/* 42 */     this.itemlist = _itemlist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.siftcfgid);
/* 51 */     _os_.compact_uint32(this.itemlist.size());
/* 52 */     for (Integer _v_ : this.itemlist) {
/* 53 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.siftcfgid = _os_.unmarshal_int();
/* 60 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 62 */       int _v_ = _os_.unmarshal_int();
/* 63 */       this.itemlist.add(Integer.valueOf(_v_));
/*    */     }
/* 65 */     if (!_validator_()) {
/* 66 */       throw new VerifyError("validator failed");
/*    */     }
/* 68 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 72 */     if (_o1_ == this) return true;
/* 73 */     if ((_o1_ instanceof SSiftItemRes)) {
/* 74 */       SSiftItemRes _o_ = (SSiftItemRes)_o1_;
/* 75 */       if (this.siftcfgid != _o_.siftcfgid) return false;
/* 76 */       if (!this.itemlist.equals(_o_.itemlist)) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.siftcfgid;
/* 85 */     _h_ += this.itemlist.hashCode();
/* 86 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 90 */     StringBuilder _sb_ = new StringBuilder();
/* 91 */     _sb_.append("(");
/* 92 */     _sb_.append(this.siftcfgid).append(",");
/* 93 */     _sb_.append(this.itemlist).append(",");
/* 94 */     _sb_.append(")");
/* 95 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SSiftItemRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */