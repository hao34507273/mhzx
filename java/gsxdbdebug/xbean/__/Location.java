/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ import xdb.logs.LogInt;
/*     */ 
/*     */ public final class Location extends XBean implements xbean.Location
/*     */ {
/*     */   private int x;
/*     */   private int y;
/*     */   private int z;
/*     */   private int sceneid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.x = 0;
/*  25 */     this.y = 0;
/*  26 */     this.z = 0;
/*  27 */     this.sceneid = 0;
/*     */   }
/*     */   
/*     */   Location(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.x = 0;
/*  34 */     this.y = 0;
/*  35 */     this.z = 0;
/*  36 */     this.sceneid = 0;
/*     */   }
/*     */   
/*     */   public Location()
/*     */   {
/*  41 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public Location(Location _o_)
/*     */   {
/*  46 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   Location(xbean.Location _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  51 */     super(_xp_, _vn_);
/*  52 */     if ((_o1_ instanceof Location)) { assign((Location)_o1_);
/*  53 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  54 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  55 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Location _o_) {
/*  60 */     _o_._xdb_verify_unsafe_();
/*  61 */     this.x = _o_.x;
/*  62 */     this.y = _o_.y;
/*  63 */     this.z = _o_.z;
/*  64 */     this.sceneid = _o_.sceneid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  69 */     this.x = _o_.x;
/*  70 */     this.y = _o_.y;
/*  71 */     this.z = _o_.z;
/*  72 */     this.sceneid = _o_.sceneid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  78 */     _xdb_verify_unsafe_();
/*  79 */     _os_.marshal(this.x);
/*  80 */     _os_.marshal(this.y);
/*  81 */     _os_.marshal(this.z);
/*  82 */     _os_.marshal(this.sceneid);
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     this.x = _os_.unmarshal_int();
/*  91 */     this.y = _os_.unmarshal_int();
/*  92 */     this.z = _os_.unmarshal_int();
/*  93 */     this.sceneid = _os_.unmarshal_int();
/*  94 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/* 101 */     int _size_ = 0;
/* 102 */     _size_ += CodedOutputStream.computeInt32Size(1, this.x);
/* 103 */     _size_ += CodedOutputStream.computeInt32Size(2, this.y);
/* 104 */     _size_ += CodedOutputStream.computeInt32Size(3, this.z);
/* 105 */     _size_ += CodedOutputStream.computeInt32Size(4, this.sceneid);
/* 106 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 112 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 115 */       _output_.writeInt32(1, this.x);
/* 116 */       _output_.writeInt32(2, this.y);
/* 117 */       _output_.writeInt32(3, this.z);
/* 118 */       _output_.writeInt32(4, this.sceneid);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 122 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 124 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 130 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 133 */       boolean done = false;
/* 134 */       while (!done)
/*     */       {
/* 136 */         int tag = _input_.readTag();
/* 137 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 141 */           done = true;
/* 142 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 146 */           this.x = _input_.readInt32();
/* 147 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 151 */           this.y = _input_.readInt32();
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 156 */           this.z = _input_.readInt32();
/* 157 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 161 */           this.sceneid = _input_.readInt32();
/* 162 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 166 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 168 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 177 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 181 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 183 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Location copy()
/*     */   {
/* 189 */     _xdb_verify_unsafe_();
/* 190 */     return new Location(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Location toData()
/*     */   {
/* 196 */     _xdb_verify_unsafe_();
/* 197 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Location toBean()
/*     */   {
/* 202 */     _xdb_verify_unsafe_();
/* 203 */     return new Location(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Location toDataIf()
/*     */   {
/* 209 */     _xdb_verify_unsafe_();
/* 210 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Location toBeanIf()
/*     */   {
/* 215 */     _xdb_verify_unsafe_();
/* 216 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 222 */     _xdb_verify_unsafe_();
/* 223 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getX()
/*     */   {
/* 230 */     _xdb_verify_unsafe_();
/* 231 */     return this.x;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getY()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return this.y;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getZ()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return this.z;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getSceneid()
/*     */   {
/* 254 */     _xdb_verify_unsafe_();
/* 255 */     return this.sceneid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setX(int _v_)
/*     */   {
/* 262 */     _xdb_verify_unsafe_();
/* 263 */     xdb.Logs.logIf(new LogKey(this, "x")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 267 */         new LogInt(this, Location.this.x)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 271 */             Location.this.x = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 275 */     });
/* 276 */     this.x = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setY(int _v_)
/*     */   {
/* 283 */     _xdb_verify_unsafe_();
/* 284 */     xdb.Logs.logIf(new LogKey(this, "y")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 288 */         new LogInt(this, Location.this.y)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 292 */             Location.this.y = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 296 */     });
/* 297 */     this.y = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setZ(int _v_)
/*     */   {
/* 304 */     _xdb_verify_unsafe_();
/* 305 */     xdb.Logs.logIf(new LogKey(this, "z")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 309 */         new LogInt(this, Location.this.z)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 313 */             Location.this.z = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 317 */     });
/* 318 */     this.z = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSceneid(int _v_)
/*     */   {
/* 325 */     _xdb_verify_unsafe_();
/* 326 */     xdb.Logs.logIf(new LogKey(this, "sceneid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 330 */         new LogInt(this, Location.this.sceneid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 334 */             Location.this.sceneid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 338 */     });
/* 339 */     this.sceneid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 345 */     _xdb_verify_unsafe_();
/* 346 */     Location _o_ = null;
/* 347 */     if ((_o1_ instanceof Location)) { _o_ = (Location)_o1_;
/* 348 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 349 */       return false;
/* 350 */     if (this.x != _o_.x) return false;
/* 351 */     if (this.y != _o_.y) return false;
/* 352 */     if (this.z != _o_.z) return false;
/* 353 */     if (this.sceneid != _o_.sceneid) return false;
/* 354 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 360 */     _xdb_verify_unsafe_();
/* 361 */     int _h_ = 0;
/* 362 */     _h_ += this.x;
/* 363 */     _h_ += this.y;
/* 364 */     _h_ += this.z;
/* 365 */     _h_ += this.sceneid;
/* 366 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 372 */     _xdb_verify_unsafe_();
/* 373 */     StringBuilder _sb_ = new StringBuilder();
/* 374 */     _sb_.append("(");
/* 375 */     _sb_.append(this.x);
/* 376 */     _sb_.append(",");
/* 377 */     _sb_.append(this.y);
/* 378 */     _sb_.append(",");
/* 379 */     _sb_.append(this.z);
/* 380 */     _sb_.append(",");
/* 381 */     _sb_.append(this.sceneid);
/* 382 */     _sb_.append(")");
/* 383 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 389 */     ListenableBean lb = new ListenableBean();
/* 390 */     lb.add(new ListenableChanged().setVarName("x"));
/* 391 */     lb.add(new ListenableChanged().setVarName("y"));
/* 392 */     lb.add(new ListenableChanged().setVarName("z"));
/* 393 */     lb.add(new ListenableChanged().setVarName("sceneid"));
/* 394 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.Location {
/*     */     private Const() {}
/*     */     
/*     */     Location nThis() {
/* 401 */       return Location.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 407 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Location copy()
/*     */     {
/* 413 */       return Location.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Location toData()
/*     */     {
/* 419 */       return Location.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.Location toBean()
/*     */     {
/* 424 */       return Location.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Location toDataIf()
/*     */     {
/* 430 */       return Location.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.Location toBeanIf()
/*     */     {
/* 435 */       return Location.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getX()
/*     */     {
/* 442 */       Location.this._xdb_verify_unsafe_();
/* 443 */       return Location.this.x;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getY()
/*     */     {
/* 450 */       Location.this._xdb_verify_unsafe_();
/* 451 */       return Location.this.y;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getZ()
/*     */     {
/* 458 */       Location.this._xdb_verify_unsafe_();
/* 459 */       return Location.this.z;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSceneid()
/*     */     {
/* 466 */       Location.this._xdb_verify_unsafe_();
/* 467 */       return Location.this.sceneid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setX(int _v_)
/*     */     {
/* 474 */       Location.this._xdb_verify_unsafe_();
/* 475 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setY(int _v_)
/*     */     {
/* 482 */       Location.this._xdb_verify_unsafe_();
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setZ(int _v_)
/*     */     {
/* 490 */       Location.this._xdb_verify_unsafe_();
/* 491 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSceneid(int _v_)
/*     */     {
/* 498 */       Location.this._xdb_verify_unsafe_();
/* 499 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 505 */       Location.this._xdb_verify_unsafe_();
/* 506 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 512 */       Location.this._xdb_verify_unsafe_();
/* 513 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 519 */       return Location.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 525 */       return Location.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 531 */       Location.this._xdb_verify_unsafe_();
/* 532 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 538 */       return Location.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 544 */       return Location.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 550 */       Location.this._xdb_verify_unsafe_();
/* 551 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 557 */       return Location.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 563 */       return Location.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 569 */       return Location.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 575 */       return Location.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 581 */       return Location.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 587 */       return Location.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 593 */       return Location.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.Location
/*     */   {
/*     */     private int x;
/*     */     
/*     */     private int y;
/*     */     
/*     */     private int z;
/*     */     
/*     */     private int sceneid;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 611 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 616 */       this.x = 0;
/* 617 */       this.y = 0;
/* 618 */       this.z = 0;
/* 619 */       this.sceneid = 0;
/*     */     }
/*     */     
/*     */     Data(xbean.Location _o1_)
/*     */     {
/* 624 */       if ((_o1_ instanceof Location)) { assign((Location)_o1_);
/* 625 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 626 */       } else if ((_o1_ instanceof Location.Const)) assign(((Location.Const)_o1_).nThis()); else {
/* 627 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Location _o_) {
/* 632 */       this.x = _o_.x;
/* 633 */       this.y = _o_.y;
/* 634 */       this.z = _o_.z;
/* 635 */       this.sceneid = _o_.sceneid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 640 */       this.x = _o_.x;
/* 641 */       this.y = _o_.y;
/* 642 */       this.z = _o_.z;
/* 643 */       this.sceneid = _o_.sceneid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 649 */       _os_.marshal(this.x);
/* 650 */       _os_.marshal(this.y);
/* 651 */       _os_.marshal(this.z);
/* 652 */       _os_.marshal(this.sceneid);
/* 653 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 659 */       this.x = _os_.unmarshal_int();
/* 660 */       this.y = _os_.unmarshal_int();
/* 661 */       this.z = _os_.unmarshal_int();
/* 662 */       this.sceneid = _os_.unmarshal_int();
/* 663 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 669 */       int _size_ = 0;
/* 670 */       _size_ += CodedOutputStream.computeInt32Size(1, this.x);
/* 671 */       _size_ += CodedOutputStream.computeInt32Size(2, this.y);
/* 672 */       _size_ += CodedOutputStream.computeInt32Size(3, this.z);
/* 673 */       _size_ += CodedOutputStream.computeInt32Size(4, this.sceneid);
/* 674 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 682 */         _output_.writeInt32(1, this.x);
/* 683 */         _output_.writeInt32(2, this.y);
/* 684 */         _output_.writeInt32(3, this.z);
/* 685 */         _output_.writeInt32(4, this.sceneid);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 689 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 691 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 699 */         boolean done = false;
/* 700 */         while (!done)
/*     */         {
/* 702 */           int tag = _input_.readTag();
/* 703 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 707 */             done = true;
/* 708 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 712 */             this.x = _input_.readInt32();
/* 713 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 717 */             this.y = _input_.readInt32();
/* 718 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 722 */             this.z = _input_.readInt32();
/* 723 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 727 */             this.sceneid = _input_.readInt32();
/* 728 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 732 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 734 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 743 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 747 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 749 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Location copy()
/*     */     {
/* 755 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Location toData()
/*     */     {
/* 761 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.Location toBean()
/*     */     {
/* 766 */       return new Location(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Location toDataIf()
/*     */     {
/* 772 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.Location toBeanIf()
/*     */     {
/* 777 */       return new Location(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 783 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 787 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 791 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 795 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 799 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 803 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 807 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getX()
/*     */     {
/* 814 */       return this.x;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getY()
/*     */     {
/* 821 */       return this.y;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getZ()
/*     */     {
/* 828 */       return this.z;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSceneid()
/*     */     {
/* 835 */       return this.sceneid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setX(int _v_)
/*     */     {
/* 842 */       this.x = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setY(int _v_)
/*     */     {
/* 849 */       this.y = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setZ(int _v_)
/*     */     {
/* 856 */       this.z = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSceneid(int _v_)
/*     */     {
/* 863 */       this.sceneid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 869 */       if (!(_o1_ instanceof Data)) return false;
/* 870 */       Data _o_ = (Data)_o1_;
/* 871 */       if (this.x != _o_.x) return false;
/* 872 */       if (this.y != _o_.y) return false;
/* 873 */       if (this.z != _o_.z) return false;
/* 874 */       if (this.sceneid != _o_.sceneid) return false;
/* 875 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 881 */       int _h_ = 0;
/* 882 */       _h_ += this.x;
/* 883 */       _h_ += this.y;
/* 884 */       _h_ += this.z;
/* 885 */       _h_ += this.sceneid;
/* 886 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 892 */       StringBuilder _sb_ = new StringBuilder();
/* 893 */       _sb_.append("(");
/* 894 */       _sb_.append(this.x);
/* 895 */       _sb_.append(",");
/* 896 */       _sb_.append(this.y);
/* 897 */       _sb_.append(",");
/* 898 */       _sb_.append(this.z);
/* 899 */       _sb_.append(",");
/* 900 */       _sb_.append(this.sceneid);
/* 901 */       _sb_.append(")");
/* 902 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Location.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */