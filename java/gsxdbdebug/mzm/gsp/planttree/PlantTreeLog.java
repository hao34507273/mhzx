/*    */ package mzm.gsp.planttree;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class PlantTreeLog
/*    */   implements Marshal
/*    */ {
/*    */   public static final int TYPE_ONLINR_REWARD_POINT = 1;
/*    */   public static final int TYPE_ADD_POINT_OPERATION = 2;
/*    */   public static final int TYPE_REMOVE_SPECIAL_STATE = 3;
/*    */   public static final int TYPE_SECTION_COMPLETE = 4;
/*    */   public static final int TYPE_ADD_SPECIAL_STATE = 5;
/*    */   public int log_type;
/*    */   public int timestamp;
/*    */   public ArrayList<String> extradatas;
/*    */   
/*    */   public PlantTreeLog()
/*    */   {
/* 22 */     this.extradatas = new ArrayList();
/*    */   }
/*    */   
/*    */   public PlantTreeLog(int _log_type_, int _timestamp_, ArrayList<String> _extradatas_) {
/* 26 */     this.log_type = _log_type_;
/* 27 */     this.timestamp = _timestamp_;
/* 28 */     this.extradatas = _extradatas_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 36 */     _os_.marshal(this.log_type);
/* 37 */     _os_.marshal(this.timestamp);
/* 38 */     _os_.compact_uint32(this.extradatas.size());
/* 39 */     for (String _v_ : this.extradatas) {
/* 40 */       _os_.marshal(_v_, "UTF-16LE");
/*    */     }
/* 42 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 46 */     this.log_type = _os_.unmarshal_int();
/* 47 */     this.timestamp = _os_.unmarshal_int();
/* 48 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 50 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/* 51 */       this.extradatas.add(_v_);
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof PlantTreeLog)) {
/* 59 */       PlantTreeLog _o_ = (PlantTreeLog)_o1_;
/* 60 */       if (this.log_type != _o_.log_type) return false;
/* 61 */       if (this.timestamp != _o_.timestamp) return false;
/* 62 */       if (!this.extradatas.equals(_o_.extradatas)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.log_type;
/* 71 */     _h_ += this.timestamp;
/* 72 */     _h_ += this.extradatas.hashCode();
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.log_type).append(",");
/* 80 */     _sb_.append(this.timestamp).append(",");
/* 81 */     _sb_.append(this.extradatas).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\PlantTreeLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */