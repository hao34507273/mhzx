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
/*     */ public final class LineUp extends XBean implements xbean.LineUp
/*     */ {
/*     */   private HashMap<Integer, Integer> positions;
/*     */   private int zhenfaid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.positions.clear();
/*  21 */     this.zhenfaid = 0;
/*     */   }
/*     */   
/*     */   LineUp(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.positions = new HashMap();
/*     */   }
/*     */   
/*     */   public LineUp()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public LineUp(LineUp _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   LineUp(xbean.LineUp _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof LineUp)) { assign((LineUp)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(LineUp _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.positions = new HashMap();
/*  53 */     for (Map.Entry<Integer, Integer> _e_ : _o_.positions.entrySet())
/*  54 */       this.positions.put(_e_.getKey(), _e_.getValue());
/*  55 */     this.zhenfaid = _o_.zhenfaid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  60 */     this.positions = new HashMap();
/*  61 */     for (Map.Entry<Integer, Integer> _e_ : _o_.positions.entrySet())
/*  62 */       this.positions.put(_e_.getKey(), _e_.getValue());
/*  63 */     this.zhenfaid = _o_.zhenfaid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.compact_uint32(this.positions.size());
/*  71 */     for (Map.Entry<Integer, Integer> _e_ : this.positions.entrySet())
/*     */     {
/*  73 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  74 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  76 */     _os_.marshal(this.zhenfaid);
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*     */     
/*  85 */     int size = _os_.uncompact_uint32();
/*  86 */     if (size >= 12)
/*     */     {
/*  88 */       this.positions = new HashMap(size * 2);
/*     */     }
/*  90 */     for (; size > 0; size--)
/*     */     {
/*  92 */       int _k_ = 0;
/*  93 */       _k_ = _os_.unmarshal_int();
/*  94 */       int _v_ = 0;
/*  95 */       _v_ = _os_.unmarshal_int();
/*  96 */       this.positions.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/*  99 */     this.zhenfaid = _os_.unmarshal_int();
/* 100 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 106 */     _xdb_verify_unsafe_();
/* 107 */     int _size_ = 0;
/* 108 */     for (Map.Entry<Integer, Integer> _e_ : this.positions.entrySet())
/*     */     {
/* 110 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 111 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 113 */     _size_ += CodedOutputStream.computeInt32Size(2, this.zhenfaid);
/* 114 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 123 */       for (Map.Entry<Integer, Integer> _e_ : this.positions.entrySet())
/*     */       {
/* 125 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 126 */         _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 128 */       _output_.writeInt32(2, this.zhenfaid);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 132 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 134 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 140 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 143 */       boolean done = false;
/* 144 */       while (!done)
/*     */       {
/* 146 */         int tag = _input_.readTag();
/* 147 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 151 */           done = true;
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 156 */           int _k_ = 0;
/* 157 */           _k_ = _input_.readInt32();
/* 158 */           int readTag = _input_.readTag();
/* 159 */           if (8 != readTag)
/*     */           {
/* 161 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 163 */           int _v_ = 0;
/* 164 */           _v_ = _input_.readInt32();
/* 165 */           this.positions.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 166 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 170 */           this.zhenfaid = _input_.readInt32();
/* 171 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 175 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 177 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 186 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 190 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 192 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.LineUp copy()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new LineUp(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.LineUp toData()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.LineUp toBean()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new LineUp(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.LineUp toDataIf()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.LineUp toBeanIf()
/*     */   {
/* 224 */     _xdb_verify_unsafe_();
/* 225 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getPositions()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return xdb.Logs.logMap(new xdb.LogKey(this, "positions"), this.positions);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getPositionsAsData()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/*     */     
/* 249 */     LineUp _o_ = this;
/* 250 */     Map<Integer, Integer> positions = new HashMap();
/* 251 */     for (Map.Entry<Integer, Integer> _e_ : _o_.positions.entrySet())
/* 252 */       positions.put(_e_.getKey(), _e_.getValue());
/* 253 */     return positions;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getZhenfaid()
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     return this.zhenfaid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setZhenfaid(int _v_)
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     xdb.Logs.logIf(new xdb.LogKey(this, "zhenfaid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 273 */         new xdb.logs.LogInt(this, LineUp.this.zhenfaid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 277 */             LineUp.this.zhenfaid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 281 */     });
/* 282 */     this.zhenfaid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     LineUp _o_ = null;
/* 290 */     if ((_o1_ instanceof LineUp)) { _o_ = (LineUp)_o1_;
/* 291 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 292 */       return false;
/* 293 */     if (!this.positions.equals(_o_.positions)) return false;
/* 294 */     if (this.zhenfaid != _o_.zhenfaid) return false;
/* 295 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     int _h_ = 0;
/* 303 */     _h_ += this.positions.hashCode();
/* 304 */     _h_ += this.zhenfaid;
/* 305 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     StringBuilder _sb_ = new StringBuilder();
/* 313 */     _sb_.append("(");
/* 314 */     _sb_.append(this.positions);
/* 315 */     _sb_.append(",");
/* 316 */     _sb_.append(this.zhenfaid);
/* 317 */     _sb_.append(")");
/* 318 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 324 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 325 */     lb.add(new xdb.logs.ListenableMap().setVarName("positions"));
/* 326 */     lb.add(new xdb.logs.ListenableChanged().setVarName("zhenfaid"));
/* 327 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.LineUp {
/*     */     private Const() {}
/*     */     
/*     */     LineUp nThis() {
/* 334 */       return LineUp.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 340 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LineUp copy()
/*     */     {
/* 346 */       return LineUp.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LineUp toData()
/*     */     {
/* 352 */       return LineUp.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.LineUp toBean()
/*     */     {
/* 357 */       return LineUp.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LineUp toDataIf()
/*     */     {
/* 363 */       return LineUp.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.LineUp toBeanIf()
/*     */     {
/* 368 */       return LineUp.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getPositions()
/*     */     {
/* 375 */       LineUp.this._xdb_verify_unsafe_();
/* 376 */       return xdb.Consts.constMap(LineUp.this.positions);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getPositionsAsData()
/*     */     {
/* 383 */       LineUp.this._xdb_verify_unsafe_();
/*     */       
/* 385 */       LineUp _o_ = LineUp.this;
/* 386 */       Map<Integer, Integer> positions = new HashMap();
/* 387 */       for (Map.Entry<Integer, Integer> _e_ : _o_.positions.entrySet())
/* 388 */         positions.put(_e_.getKey(), _e_.getValue());
/* 389 */       return positions;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getZhenfaid()
/*     */     {
/* 396 */       LineUp.this._xdb_verify_unsafe_();
/* 397 */       return LineUp.this.zhenfaid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setZhenfaid(int _v_)
/*     */     {
/* 404 */       LineUp.this._xdb_verify_unsafe_();
/* 405 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 411 */       LineUp.this._xdb_verify_unsafe_();
/* 412 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 418 */       LineUp.this._xdb_verify_unsafe_();
/* 419 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 425 */       return LineUp.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 431 */       return LineUp.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 437 */       LineUp.this._xdb_verify_unsafe_();
/* 438 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 444 */       return LineUp.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 450 */       return LineUp.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 456 */       LineUp.this._xdb_verify_unsafe_();
/* 457 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 463 */       return LineUp.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 469 */       return LineUp.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 475 */       return LineUp.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 481 */       return LineUp.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 487 */       return LineUp.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 493 */       return LineUp.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 499 */       return LineUp.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.LineUp
/*     */   {
/*     */     private HashMap<Integer, Integer> positions;
/*     */     
/*     */     private int zhenfaid;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 513 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 518 */       this.positions = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.LineUp _o1_)
/*     */     {
/* 523 */       if ((_o1_ instanceof LineUp)) { assign((LineUp)_o1_);
/* 524 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 525 */       } else if ((_o1_ instanceof LineUp.Const)) assign(((LineUp.Const)_o1_).nThis()); else {
/* 526 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(LineUp _o_) {
/* 531 */       this.positions = new HashMap();
/* 532 */       for (Map.Entry<Integer, Integer> _e_ : _o_.positions.entrySet())
/* 533 */         this.positions.put(_e_.getKey(), _e_.getValue());
/* 534 */       this.zhenfaid = _o_.zhenfaid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 539 */       this.positions = new HashMap();
/* 540 */       for (Map.Entry<Integer, Integer> _e_ : _o_.positions.entrySet())
/* 541 */         this.positions.put(_e_.getKey(), _e_.getValue());
/* 542 */       this.zhenfaid = _o_.zhenfaid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 548 */       _os_.compact_uint32(this.positions.size());
/* 549 */       for (Map.Entry<Integer, Integer> _e_ : this.positions.entrySet())
/*     */       {
/* 551 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 552 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 554 */       _os_.marshal(this.zhenfaid);
/* 555 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 562 */       int size = _os_.uncompact_uint32();
/* 563 */       if (size >= 12)
/*     */       {
/* 565 */         this.positions = new HashMap(size * 2);
/*     */       }
/* 567 */       for (; size > 0; size--)
/*     */       {
/* 569 */         int _k_ = 0;
/* 570 */         _k_ = _os_.unmarshal_int();
/* 571 */         int _v_ = 0;
/* 572 */         _v_ = _os_.unmarshal_int();
/* 573 */         this.positions.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 576 */       this.zhenfaid = _os_.unmarshal_int();
/* 577 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 583 */       int _size_ = 0;
/* 584 */       for (Map.Entry<Integer, Integer> _e_ : this.positions.entrySet())
/*     */       {
/* 586 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 587 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 589 */       _size_ += CodedOutputStream.computeInt32Size(2, this.zhenfaid);
/* 590 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 598 */         for (Map.Entry<Integer, Integer> _e_ : this.positions.entrySet())
/*     */         {
/* 600 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 601 */           _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*     */         }
/* 603 */         _output_.writeInt32(2, this.zhenfaid);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 607 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 609 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 617 */         boolean done = false;
/* 618 */         while (!done)
/*     */         {
/* 620 */           int tag = _input_.readTag();
/* 621 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 625 */             done = true;
/* 626 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 630 */             int _k_ = 0;
/* 631 */             _k_ = _input_.readInt32();
/* 632 */             int readTag = _input_.readTag();
/* 633 */             if (8 != readTag)
/*     */             {
/* 635 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 637 */             int _v_ = 0;
/* 638 */             _v_ = _input_.readInt32();
/* 639 */             this.positions.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 640 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 644 */             this.zhenfaid = _input_.readInt32();
/* 645 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 649 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 651 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 660 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 664 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 666 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LineUp copy()
/*     */     {
/* 672 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LineUp toData()
/*     */     {
/* 678 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.LineUp toBean()
/*     */     {
/* 683 */       return new LineUp(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LineUp toDataIf()
/*     */     {
/* 689 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.LineUp toBeanIf()
/*     */     {
/* 694 */       return new LineUp(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 700 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 704 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 708 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 712 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 716 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 720 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 724 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getPositions()
/*     */     {
/* 731 */       return this.positions;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getPositionsAsData()
/*     */     {
/* 738 */       return this.positions;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getZhenfaid()
/*     */     {
/* 745 */       return this.zhenfaid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setZhenfaid(int _v_)
/*     */     {
/* 752 */       this.zhenfaid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 758 */       if (!(_o1_ instanceof Data)) return false;
/* 759 */       Data _o_ = (Data)_o1_;
/* 760 */       if (!this.positions.equals(_o_.positions)) return false;
/* 761 */       if (this.zhenfaid != _o_.zhenfaid) return false;
/* 762 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 768 */       int _h_ = 0;
/* 769 */       _h_ += this.positions.hashCode();
/* 770 */       _h_ += this.zhenfaid;
/* 771 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 777 */       StringBuilder _sb_ = new StringBuilder();
/* 778 */       _sb_.append("(");
/* 779 */       _sb_.append(this.positions);
/* 780 */       _sb_.append(",");
/* 781 */       _sb_.append(this.zhenfaid);
/* 782 */       _sb_.append(")");
/* 783 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\LineUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */