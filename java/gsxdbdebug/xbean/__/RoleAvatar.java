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
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class RoleAvatar extends XBean implements xbean.RoleAvatar
/*     */ {
/*     */   private int _current_avatar;
/*     */   private int _active_avatar;
/*     */   private HashMap<Integer, Integer> _avatars;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this._current_avatar = 0;
/*  23 */     this._active_avatar = 0;
/*  24 */     this._avatars.clear();
/*     */   }
/*     */   
/*     */   RoleAvatar(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this._avatars = new HashMap();
/*     */   }
/*     */   
/*     */   public RoleAvatar()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoleAvatar(RoleAvatar _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoleAvatar(xbean.RoleAvatar _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof RoleAvatar)) { assign((RoleAvatar)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RoleAvatar _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this._current_avatar = _o_._current_avatar;
/*  56 */     this._active_avatar = _o_._active_avatar;
/*  57 */     this._avatars = new HashMap();
/*  58 */     for (Map.Entry<Integer, Integer> _e_ : _o_._avatars.entrySet()) {
/*  59 */       this._avatars.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  64 */     this._current_avatar = _o_._current_avatar;
/*  65 */     this._active_avatar = _o_._active_avatar;
/*  66 */     this._avatars = new HashMap();
/*  67 */     for (Map.Entry<Integer, Integer> _e_ : _o_._avatars.entrySet()) {
/*  68 */       this._avatars.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.marshal(this._current_avatar);
/*  76 */     _os_.marshal(this._active_avatar);
/*  77 */     _os_.compact_uint32(this._avatars.size());
/*  78 */     for (Map.Entry<Integer, Integer> _e_ : this._avatars.entrySet())
/*     */     {
/*  80 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  81 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     this._current_avatar = _os_.unmarshal_int();
/*  91 */     this._active_avatar = _os_.unmarshal_int();
/*     */     
/*  93 */     int size = _os_.uncompact_uint32();
/*  94 */     if (size >= 12)
/*     */     {
/*  96 */       this._avatars = new HashMap(size * 2);
/*     */     }
/*  98 */     for (; size > 0; size--)
/*     */     {
/* 100 */       int _k_ = 0;
/* 101 */       _k_ = _os_.unmarshal_int();
/* 102 */       int _v_ = 0;
/* 103 */       _v_ = _os_.unmarshal_int();
/* 104 */       this._avatars.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/* 107 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 113 */     _xdb_verify_unsafe_();
/* 114 */     int _size_ = 0;
/* 115 */     _size_ += CodedOutputStream.computeInt32Size(1, this._current_avatar);
/* 116 */     _size_ += CodedOutputStream.computeInt32Size(2, this._active_avatar);
/* 117 */     for (Map.Entry<Integer, Integer> _e_ : this._avatars.entrySet())
/*     */     {
/* 119 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 120 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 122 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 128 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 131 */       _output_.writeInt32(1, this._current_avatar);
/* 132 */       _output_.writeInt32(2, this._active_avatar);
/* 133 */       for (Map.Entry<Integer, Integer> _e_ : this._avatars.entrySet())
/*     */       {
/* 135 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 136 */         _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 141 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 143 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 149 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 152 */       boolean done = false;
/* 153 */       while (!done)
/*     */       {
/* 155 */         int tag = _input_.readTag();
/* 156 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 160 */           done = true;
/* 161 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 165 */           this._current_avatar = _input_.readInt32();
/* 166 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 170 */           this._active_avatar = _input_.readInt32();
/* 171 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 175 */           int _k_ = 0;
/* 176 */           _k_ = _input_.readInt32();
/* 177 */           int readTag = _input_.readTag();
/* 178 */           if (24 != readTag)
/*     */           {
/* 180 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 182 */           int _v_ = 0;
/* 183 */           _v_ = _input_.readInt32();
/* 184 */           this._avatars.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 185 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 189 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 191 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 200 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 204 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 206 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleAvatar copy()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new RoleAvatar(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleAvatar toData()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleAvatar toBean()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return new RoleAvatar(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleAvatar toDataIf()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleAvatar toBeanIf()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int get_current_avatar()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return this._current_avatar;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int get_active_avatar()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return this._active_avatar;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> get_avatars()
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     return xdb.Logs.logMap(new LogKey(this, "_avatars"), this._avatars);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> get_avatarsAsData()
/*     */   {
/* 277 */     _xdb_verify_unsafe_();
/*     */     
/* 279 */     RoleAvatar _o_ = this;
/* 280 */     Map<Integer, Integer> _avatars = new HashMap();
/* 281 */     for (Map.Entry<Integer, Integer> _e_ : _o_._avatars.entrySet())
/* 282 */       _avatars.put(_e_.getKey(), _e_.getValue());
/* 283 */     return _avatars;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void set_current_avatar(int _v_)
/*     */   {
/* 290 */     _xdb_verify_unsafe_();
/* 291 */     xdb.Logs.logIf(new LogKey(this, "_current_avatar")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 295 */         new xdb.logs.LogInt(this, RoleAvatar.this._current_avatar)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 299 */             RoleAvatar.this._current_avatar = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 303 */     });
/* 304 */     this._current_avatar = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void set_active_avatar(int _v_)
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     xdb.Logs.logIf(new LogKey(this, "_active_avatar")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 316 */         new xdb.logs.LogInt(this, RoleAvatar.this._active_avatar)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 320 */             RoleAvatar.this._active_avatar = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 324 */     });
/* 325 */     this._active_avatar = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 331 */     _xdb_verify_unsafe_();
/* 332 */     RoleAvatar _o_ = null;
/* 333 */     if ((_o1_ instanceof RoleAvatar)) { _o_ = (RoleAvatar)_o1_;
/* 334 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 335 */       return false;
/* 336 */     if (this._current_avatar != _o_._current_avatar) return false;
/* 337 */     if (this._active_avatar != _o_._active_avatar) return false;
/* 338 */     if (!this._avatars.equals(_o_._avatars)) return false;
/* 339 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 345 */     _xdb_verify_unsafe_();
/* 346 */     int _h_ = 0;
/* 347 */     _h_ += this._current_avatar;
/* 348 */     _h_ += this._active_avatar;
/* 349 */     _h_ += this._avatars.hashCode();
/* 350 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 356 */     _xdb_verify_unsafe_();
/* 357 */     StringBuilder _sb_ = new StringBuilder();
/* 358 */     _sb_.append("(");
/* 359 */     _sb_.append(this._current_avatar);
/* 360 */     _sb_.append(",");
/* 361 */     _sb_.append(this._active_avatar);
/* 362 */     _sb_.append(",");
/* 363 */     _sb_.append(this._avatars);
/* 364 */     _sb_.append(")");
/* 365 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 371 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 372 */     lb.add(new xdb.logs.ListenableChanged().setVarName("_current_avatar"));
/* 373 */     lb.add(new xdb.logs.ListenableChanged().setVarName("_active_avatar"));
/* 374 */     lb.add(new xdb.logs.ListenableMap().setVarName("_avatars"));
/* 375 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoleAvatar {
/*     */     private Const() {}
/*     */     
/*     */     RoleAvatar nThis() {
/* 382 */       return RoleAvatar.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 388 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleAvatar copy()
/*     */     {
/* 394 */       return RoleAvatar.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleAvatar toData()
/*     */     {
/* 400 */       return RoleAvatar.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoleAvatar toBean()
/*     */     {
/* 405 */       return RoleAvatar.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleAvatar toDataIf()
/*     */     {
/* 411 */       return RoleAvatar.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoleAvatar toBeanIf()
/*     */     {
/* 416 */       return RoleAvatar.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int get_current_avatar()
/*     */     {
/* 423 */       RoleAvatar.this._xdb_verify_unsafe_();
/* 424 */       return RoleAvatar.this._current_avatar;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int get_active_avatar()
/*     */     {
/* 431 */       RoleAvatar.this._xdb_verify_unsafe_();
/* 432 */       return RoleAvatar.this._active_avatar;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> get_avatars()
/*     */     {
/* 439 */       RoleAvatar.this._xdb_verify_unsafe_();
/* 440 */       return xdb.Consts.constMap(RoleAvatar.this._avatars);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> get_avatarsAsData()
/*     */     {
/* 447 */       RoleAvatar.this._xdb_verify_unsafe_();
/*     */       
/* 449 */       RoleAvatar _o_ = RoleAvatar.this;
/* 450 */       Map<Integer, Integer> _avatars = new HashMap();
/* 451 */       for (Map.Entry<Integer, Integer> _e_ : _o_._avatars.entrySet())
/* 452 */         _avatars.put(_e_.getKey(), _e_.getValue());
/* 453 */       return _avatars;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void set_current_avatar(int _v_)
/*     */     {
/* 460 */       RoleAvatar.this._xdb_verify_unsafe_();
/* 461 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void set_active_avatar(int _v_)
/*     */     {
/* 468 */       RoleAvatar.this._xdb_verify_unsafe_();
/* 469 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 475 */       RoleAvatar.this._xdb_verify_unsafe_();
/* 476 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 482 */       RoleAvatar.this._xdb_verify_unsafe_();
/* 483 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 489 */       return RoleAvatar.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 495 */       return RoleAvatar.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 501 */       RoleAvatar.this._xdb_verify_unsafe_();
/* 502 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 508 */       return RoleAvatar.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 514 */       return RoleAvatar.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 520 */       RoleAvatar.this._xdb_verify_unsafe_();
/* 521 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 527 */       return RoleAvatar.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 533 */       return RoleAvatar.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 539 */       return RoleAvatar.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 545 */       return RoleAvatar.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 551 */       return RoleAvatar.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 557 */       return RoleAvatar.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 563 */       return RoleAvatar.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoleAvatar
/*     */   {
/*     */     private int _current_avatar;
/*     */     
/*     */     private int _active_avatar;
/*     */     
/*     */     private HashMap<Integer, Integer> _avatars;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 579 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 584 */       this._avatars = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.RoleAvatar _o1_)
/*     */     {
/* 589 */       if ((_o1_ instanceof RoleAvatar)) { assign((RoleAvatar)_o1_);
/* 590 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 591 */       } else if ((_o1_ instanceof RoleAvatar.Const)) assign(((RoleAvatar.Const)_o1_).nThis()); else {
/* 592 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RoleAvatar _o_) {
/* 597 */       this._current_avatar = _o_._current_avatar;
/* 598 */       this._active_avatar = _o_._active_avatar;
/* 599 */       this._avatars = new HashMap();
/* 600 */       for (Map.Entry<Integer, Integer> _e_ : _o_._avatars.entrySet()) {
/* 601 */         this._avatars.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 606 */       this._current_avatar = _o_._current_avatar;
/* 607 */       this._active_avatar = _o_._active_avatar;
/* 608 */       this._avatars = new HashMap();
/* 609 */       for (Map.Entry<Integer, Integer> _e_ : _o_._avatars.entrySet()) {
/* 610 */         this._avatars.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 616 */       _os_.marshal(this._current_avatar);
/* 617 */       _os_.marshal(this._active_avatar);
/* 618 */       _os_.compact_uint32(this._avatars.size());
/* 619 */       for (Map.Entry<Integer, Integer> _e_ : this._avatars.entrySet())
/*     */       {
/* 621 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 622 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 624 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 630 */       this._current_avatar = _os_.unmarshal_int();
/* 631 */       this._active_avatar = _os_.unmarshal_int();
/*     */       
/* 633 */       int size = _os_.uncompact_uint32();
/* 634 */       if (size >= 12)
/*     */       {
/* 636 */         this._avatars = new HashMap(size * 2);
/*     */       }
/* 638 */       for (; size > 0; size--)
/*     */       {
/* 640 */         int _k_ = 0;
/* 641 */         _k_ = _os_.unmarshal_int();
/* 642 */         int _v_ = 0;
/* 643 */         _v_ = _os_.unmarshal_int();
/* 644 */         this._avatars.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 647 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 653 */       int _size_ = 0;
/* 654 */       _size_ += CodedOutputStream.computeInt32Size(1, this._current_avatar);
/* 655 */       _size_ += CodedOutputStream.computeInt32Size(2, this._active_avatar);
/* 656 */       for (Map.Entry<Integer, Integer> _e_ : this._avatars.entrySet())
/*     */       {
/* 658 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 659 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 661 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 669 */         _output_.writeInt32(1, this._current_avatar);
/* 670 */         _output_.writeInt32(2, this._active_avatar);
/* 671 */         for (Map.Entry<Integer, Integer> _e_ : this._avatars.entrySet())
/*     */         {
/* 673 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 674 */           _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 679 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 681 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 689 */         boolean done = false;
/* 690 */         while (!done)
/*     */         {
/* 692 */           int tag = _input_.readTag();
/* 693 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 697 */             done = true;
/* 698 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 702 */             this._current_avatar = _input_.readInt32();
/* 703 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 707 */             this._active_avatar = _input_.readInt32();
/* 708 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 712 */             int _k_ = 0;
/* 713 */             _k_ = _input_.readInt32();
/* 714 */             int readTag = _input_.readTag();
/* 715 */             if (24 != readTag)
/*     */             {
/* 717 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 719 */             int _v_ = 0;
/* 720 */             _v_ = _input_.readInt32();
/* 721 */             this._avatars.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 722 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 726 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 728 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 737 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 741 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 743 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleAvatar copy()
/*     */     {
/* 749 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleAvatar toData()
/*     */     {
/* 755 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoleAvatar toBean()
/*     */     {
/* 760 */       return new RoleAvatar(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleAvatar toDataIf()
/*     */     {
/* 766 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoleAvatar toBeanIf()
/*     */     {
/* 771 */       return new RoleAvatar(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 777 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 781 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 785 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 789 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 793 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 797 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 801 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int get_current_avatar()
/*     */     {
/* 808 */       return this._current_avatar;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int get_active_avatar()
/*     */     {
/* 815 */       return this._active_avatar;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> get_avatars()
/*     */     {
/* 822 */       return this._avatars;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> get_avatarsAsData()
/*     */     {
/* 829 */       return this._avatars;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void set_current_avatar(int _v_)
/*     */     {
/* 836 */       this._current_avatar = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void set_active_avatar(int _v_)
/*     */     {
/* 843 */       this._active_avatar = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 849 */       if (!(_o1_ instanceof Data)) return false;
/* 850 */       Data _o_ = (Data)_o1_;
/* 851 */       if (this._current_avatar != _o_._current_avatar) return false;
/* 852 */       if (this._active_avatar != _o_._active_avatar) return false;
/* 853 */       if (!this._avatars.equals(_o_._avatars)) return false;
/* 854 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 860 */       int _h_ = 0;
/* 861 */       _h_ += this._current_avatar;
/* 862 */       _h_ += this._active_avatar;
/* 863 */       _h_ += this._avatars.hashCode();
/* 864 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 870 */       StringBuilder _sb_ = new StringBuilder();
/* 871 */       _sb_.append("(");
/* 872 */       _sb_.append(this._current_avatar);
/* 873 */       _sb_.append(",");
/* 874 */       _sb_.append(this._active_avatar);
/* 875 */       _sb_.append(",");
/* 876 */       _sb_.append(this._avatars);
/* 877 */       _sb_.append(")");
/* 878 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleAvatar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */