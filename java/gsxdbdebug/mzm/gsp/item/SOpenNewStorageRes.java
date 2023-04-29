/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SOpenNewStorageRes
/*    */   extends __SOpenNewStorageRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584812;
/*    */   public int storageid;
/*    */   public String name;
/*    */   public int capacity;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12584812;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SOpenNewStorageRes()
/*    */   {
/* 33 */     this.name = "";
/*    */   }
/*    */   
/*    */   public SOpenNewStorageRes(int _storageid_, String _name_, int _capacity_) {
/* 37 */     this.storageid = _storageid_;
/* 38 */     this.name = _name_;
/* 39 */     this.capacity = _capacity_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.storageid);
/* 48 */     _os_.marshal(this.name, "UTF-16LE");
/* 49 */     _os_.marshal(this.capacity);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.storageid = _os_.unmarshal_int();
/* 55 */     this.name = _os_.unmarshal_String("UTF-16LE");
/* 56 */     this.capacity = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof SOpenNewStorageRes)) {
/* 66 */       SOpenNewStorageRes _o_ = (SOpenNewStorageRes)_o1_;
/* 67 */       if (this.storageid != _o_.storageid) return false;
/* 68 */       if (!this.name.equals(_o_.name)) return false;
/* 69 */       if (this.capacity != _o_.capacity) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.storageid;
/* 78 */     _h_ += this.name.hashCode();
/* 79 */     _h_ += this.capacity;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.storageid).append(",");
/* 87 */     _sb_.append("T").append(this.name.length()).append(",");
/* 88 */     _sb_.append(this.capacity).append(",");
/* 89 */     _sb_.append(")");
/* 90 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SOpenNewStorageRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */