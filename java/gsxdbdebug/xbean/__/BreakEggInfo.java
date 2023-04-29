/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class BreakEggInfo extends XBean implements xbean.BreakEggInfo
/*     */ {
/*     */   private long role_id;
/*     */   private HashMap<Integer, Integer> itemid2num;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.role_id = -1L;
/*  21 */     this.itemid2num.clear();
/*     */   }
/*     */   
/*     */   BreakEggInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.role_id = -1L;
/*  28 */     this.itemid2num = new HashMap();
/*     */   }
/*     */   
/*     */   public BreakEggInfo()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public BreakEggInfo(BreakEggInfo _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   BreakEggInfo(xbean.BreakEggInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof BreakEggInfo)) { assign((BreakEggInfo)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(BreakEggInfo _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.role_id = _o_.role_id;
/*  54 */     this.itemid2num = new HashMap();
/*  55 */     for (Map.Entry<Integer, Integer> _e_ : _o_.itemid2num.entrySet()) {
/*  56 */       this.itemid2num.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  61 */     this.role_id = _o_.role_id;
/*  62 */     this.itemid2num = new HashMap();
/*  63 */     for (Map.Entry<Integer, Integer> _e_ : _o_.itemid2num.entrySet()) {
/*  64 */       this.itemid2num.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.marshal(this.role_id);
/*  72 */     _os_.compact_uint32(this.itemid2num.size());
/*  73 */     for (Map.Entry<Integer, Integer> _e_ : this.itemid2num.entrySet())
/*     */     {
/*  75 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  76 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*  85 */     this.role_id = _os_.unmarshal_long();
/*     */     
/*  87 */     int size = _os_.uncompact_uint32();
/*  88 */     if (size >= 12)
/*     */     {
/*  90 */       this.itemid2num = new HashMap(size * 2);
/*     */     }
/*  92 */     for (; size > 0; size--)
/*     */     {
/*  94 */       int _k_ = 0;
/*  95 */       _k_ = _os_.unmarshal_int();
/*  96 */       int _v_ = 0;
/*  97 */       _v_ = _os_.unmarshal_int();
/*  98 */       this.itemid2num.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/* 101 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 107 */     _xdb_verify_unsafe_();
/* 108 */     int _size_ = 0;
/* 109 */     _size_ += CodedOutputStream.computeInt64Size(1, this.role_id);
/* 110 */     for (Map.Entry<Integer, Integer> _e_ : this.itemid2num.entrySet())
/*     */     {
/* 112 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 113 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 115 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 121 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 124 */       _output_.writeInt64(1, this.role_id);
/* 125 */       for (Map.Entry<Integer, Integer> _e_ : this.itemid2num.entrySet())
/*     */       {
/* 127 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 128 */         _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 133 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 135 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 141 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 144 */       boolean done = false;
/* 145 */       while (!done)
/*     */       {
/* 147 */         int tag = _input_.readTag();
/* 148 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 152 */           done = true;
/* 153 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 157 */           this.role_id = _input_.readInt64();
/* 158 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 162 */           int _k_ = 0;
/* 163 */           _k_ = _input_.readInt32();
/* 164 */           int readTag = _input_.readTag();
/* 165 */           if (16 != readTag)
/*     */           {
/* 167 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 169 */           int _v_ = 0;
/* 170 */           _v_ = _input_.readInt32();
/* 171 */           this.itemid2num.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 172 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 176 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 178 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 187 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 191 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 193 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.BreakEggInfo copy()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new BreakEggInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.BreakEggInfo toData()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.BreakEggInfo toBean()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new BreakEggInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.BreakEggInfo toDataIf()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.BreakEggInfo toBeanIf()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getRole_id()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return this.role_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getItemid2num()
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/* 249 */     return xdb.Logs.logMap(new xdb.LogKey(this, "itemid2num"), this.itemid2num);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getItemid2numAsData()
/*     */   {
/* 256 */     _xdb_verify_unsafe_();
/*     */     
/* 258 */     BreakEggInfo _o_ = this;
/* 259 */     Map<Integer, Integer> itemid2num = new HashMap();
/* 260 */     for (Map.Entry<Integer, Integer> _e_ : _o_.itemid2num.entrySet())
/* 261 */       itemid2num.put(_e_.getKey(), _e_.getValue());
/* 262 */     return itemid2num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRole_id(long _v_)
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     xdb.Logs.logIf(new xdb.LogKey(this, "role_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 274 */         new xdb.logs.LogLong(this, BreakEggInfo.this.role_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 278 */             BreakEggInfo.this.role_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 282 */     });
/* 283 */     this.role_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 289 */     _xdb_verify_unsafe_();
/* 290 */     BreakEggInfo _o_ = null;
/* 291 */     if ((_o1_ instanceof BreakEggInfo)) { _o_ = (BreakEggInfo)_o1_;
/* 292 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 293 */       return false;
/* 294 */     if (this.role_id != _o_.role_id) return false;
/* 295 */     if (!this.itemid2num.equals(_o_.itemid2num)) return false;
/* 296 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/* 303 */     int _h_ = 0;
/* 304 */     _h_ = (int)(_h_ + this.role_id);
/* 305 */     _h_ += this.itemid2num.hashCode();
/* 306 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     StringBuilder _sb_ = new StringBuilder();
/* 314 */     _sb_.append("(");
/* 315 */     _sb_.append(this.role_id);
/* 316 */     _sb_.append(",");
/* 317 */     _sb_.append(this.itemid2num);
/* 318 */     _sb_.append(")");
/* 319 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 325 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 326 */     lb.add(new xdb.logs.ListenableChanged().setVarName("role_id"));
/* 327 */     lb.add(new xdb.logs.ListenableMap().setVarName("itemid2num"));
/* 328 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.BreakEggInfo {
/*     */     private Const() {}
/*     */     
/*     */     BreakEggInfo nThis() {
/* 335 */       return BreakEggInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 341 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BreakEggInfo copy()
/*     */     {
/* 347 */       return BreakEggInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BreakEggInfo toData()
/*     */     {
/* 353 */       return BreakEggInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.BreakEggInfo toBean()
/*     */     {
/* 358 */       return BreakEggInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BreakEggInfo toDataIf()
/*     */     {
/* 364 */       return BreakEggInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.BreakEggInfo toBeanIf()
/*     */     {
/* 369 */       return BreakEggInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRole_id()
/*     */     {
/* 376 */       BreakEggInfo.this._xdb_verify_unsafe_();
/* 377 */       return BreakEggInfo.this.role_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getItemid2num()
/*     */     {
/* 384 */       BreakEggInfo.this._xdb_verify_unsafe_();
/* 385 */       return xdb.Consts.constMap(BreakEggInfo.this.itemid2num);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getItemid2numAsData()
/*     */     {
/* 392 */       BreakEggInfo.this._xdb_verify_unsafe_();
/*     */       
/* 394 */       BreakEggInfo _o_ = BreakEggInfo.this;
/* 395 */       Map<Integer, Integer> itemid2num = new HashMap();
/* 396 */       for (Map.Entry<Integer, Integer> _e_ : _o_.itemid2num.entrySet())
/* 397 */         itemid2num.put(_e_.getKey(), _e_.getValue());
/* 398 */       return itemid2num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRole_id(long _v_)
/*     */     {
/* 405 */       BreakEggInfo.this._xdb_verify_unsafe_();
/* 406 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 412 */       BreakEggInfo.this._xdb_verify_unsafe_();
/* 413 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 419 */       BreakEggInfo.this._xdb_verify_unsafe_();
/* 420 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 426 */       return BreakEggInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 432 */       return BreakEggInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 438 */       BreakEggInfo.this._xdb_verify_unsafe_();
/* 439 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 445 */       return BreakEggInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 451 */       return BreakEggInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 457 */       BreakEggInfo.this._xdb_verify_unsafe_();
/* 458 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 464 */       return BreakEggInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 470 */       return BreakEggInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 476 */       return BreakEggInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 482 */       return BreakEggInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 488 */       return BreakEggInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 494 */       return BreakEggInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 500 */       return BreakEggInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.BreakEggInfo
/*     */   {
/*     */     private long role_id;
/*     */     
/*     */     private HashMap<Integer, Integer> itemid2num;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 514 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 519 */       this.role_id = -1L;
/* 520 */       this.itemid2num = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.BreakEggInfo _o1_)
/*     */     {
/* 525 */       if ((_o1_ instanceof BreakEggInfo)) { assign((BreakEggInfo)_o1_);
/* 526 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 527 */       } else if ((_o1_ instanceof BreakEggInfo.Const)) assign(((BreakEggInfo.Const)_o1_).nThis()); else {
/* 528 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(BreakEggInfo _o_) {
/* 533 */       this.role_id = _o_.role_id;
/* 534 */       this.itemid2num = new HashMap();
/* 535 */       for (Map.Entry<Integer, Integer> _e_ : _o_.itemid2num.entrySet()) {
/* 536 */         this.itemid2num.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 541 */       this.role_id = _o_.role_id;
/* 542 */       this.itemid2num = new HashMap();
/* 543 */       for (Map.Entry<Integer, Integer> _e_ : _o_.itemid2num.entrySet()) {
/* 544 */         this.itemid2num.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 550 */       _os_.marshal(this.role_id);
/* 551 */       _os_.compact_uint32(this.itemid2num.size());
/* 552 */       for (Map.Entry<Integer, Integer> _e_ : this.itemid2num.entrySet())
/*     */       {
/* 554 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 555 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 557 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 563 */       this.role_id = _os_.unmarshal_long();
/*     */       
/* 565 */       int size = _os_.uncompact_uint32();
/* 566 */       if (size >= 12)
/*     */       {
/* 568 */         this.itemid2num = new HashMap(size * 2);
/*     */       }
/* 570 */       for (; size > 0; size--)
/*     */       {
/* 572 */         int _k_ = 0;
/* 573 */         _k_ = _os_.unmarshal_int();
/* 574 */         int _v_ = 0;
/* 575 */         _v_ = _os_.unmarshal_int();
/* 576 */         this.itemid2num.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 579 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 585 */       int _size_ = 0;
/* 586 */       _size_ += CodedOutputStream.computeInt64Size(1, this.role_id);
/* 587 */       for (Map.Entry<Integer, Integer> _e_ : this.itemid2num.entrySet())
/*     */       {
/* 589 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 590 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 592 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 600 */         _output_.writeInt64(1, this.role_id);
/* 601 */         for (Map.Entry<Integer, Integer> _e_ : this.itemid2num.entrySet())
/*     */         {
/* 603 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 604 */           _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 609 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 611 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 619 */         boolean done = false;
/* 620 */         while (!done)
/*     */         {
/* 622 */           int tag = _input_.readTag();
/* 623 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 627 */             done = true;
/* 628 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 632 */             this.role_id = _input_.readInt64();
/* 633 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 637 */             int _k_ = 0;
/* 638 */             _k_ = _input_.readInt32();
/* 639 */             int readTag = _input_.readTag();
/* 640 */             if (16 != readTag)
/*     */             {
/* 642 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 644 */             int _v_ = 0;
/* 645 */             _v_ = _input_.readInt32();
/* 646 */             this.itemid2num.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 647 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 651 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 653 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 662 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 666 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 668 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BreakEggInfo copy()
/*     */     {
/* 674 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BreakEggInfo toData()
/*     */     {
/* 680 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.BreakEggInfo toBean()
/*     */     {
/* 685 */       return new BreakEggInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BreakEggInfo toDataIf()
/*     */     {
/* 691 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.BreakEggInfo toBeanIf()
/*     */     {
/* 696 */       return new BreakEggInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 702 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 706 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 710 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 714 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 718 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 722 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 726 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRole_id()
/*     */     {
/* 733 */       return this.role_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getItemid2num()
/*     */     {
/* 740 */       return this.itemid2num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getItemid2numAsData()
/*     */     {
/* 747 */       return this.itemid2num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRole_id(long _v_)
/*     */     {
/* 754 */       this.role_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 760 */       if (!(_o1_ instanceof Data)) return false;
/* 761 */       Data _o_ = (Data)_o1_;
/* 762 */       if (this.role_id != _o_.role_id) return false;
/* 763 */       if (!this.itemid2num.equals(_o_.itemid2num)) return false;
/* 764 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 770 */       int _h_ = 0;
/* 771 */       _h_ = (int)(_h_ + this.role_id);
/* 772 */       _h_ += this.itemid2num.hashCode();
/* 773 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 779 */       StringBuilder _sb_ = new StringBuilder();
/* 780 */       _sb_.append("(");
/* 781 */       _sb_.append(this.role_id);
/* 782 */       _sb_.append(",");
/* 783 */       _sb_.append(this.itemid2num);
/* 784 */       _sb_.append(")");
/* 785 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\BreakEggInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */