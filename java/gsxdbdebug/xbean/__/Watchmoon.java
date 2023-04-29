/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class Watchmoon extends XBean implements xbean.Watchmoon
/*      */ {
/*      */   private long invitetime;
/*      */   private int mapid;
/*      */   private boolean iscouple;
/*      */   private long partenerroleid;
/*      */   private long groupid;
/*      */   private long sessionid;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.invitetime = -1L;
/*   29 */     this.mapid = 0;
/*   30 */     this.iscouple = false;
/*   31 */     this.partenerroleid = 0L;
/*   32 */     this.groupid = 0L;
/*   33 */     this.sessionid = 0L;
/*      */   }
/*      */   
/*      */   Watchmoon(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.invitetime = -1L;
/*   40 */     this.iscouple = false;
/*      */   }
/*      */   
/*      */   public Watchmoon()
/*      */   {
/*   45 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Watchmoon(Watchmoon _o_)
/*      */   {
/*   50 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Watchmoon(xbean.Watchmoon _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   55 */     super(_xp_, _vn_);
/*   56 */     if ((_o1_ instanceof Watchmoon)) { assign((Watchmoon)_o1_);
/*   57 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   58 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   59 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Watchmoon _o_) {
/*   64 */     _o_._xdb_verify_unsafe_();
/*   65 */     this.invitetime = _o_.invitetime;
/*   66 */     this.mapid = _o_.mapid;
/*   67 */     this.iscouple = _o_.iscouple;
/*   68 */     this.partenerroleid = _o_.partenerroleid;
/*   69 */     this.groupid = _o_.groupid;
/*   70 */     this.sessionid = _o_.sessionid;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   75 */     this.invitetime = _o_.invitetime;
/*   76 */     this.mapid = _o_.mapid;
/*   77 */     this.iscouple = _o_.iscouple;
/*   78 */     this.partenerroleid = _o_.partenerroleid;
/*   79 */     this.groupid = _o_.groupid;
/*   80 */     this.sessionid = _o_.sessionid;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   86 */     _xdb_verify_unsafe_();
/*   87 */     _os_.marshal(this.invitetime);
/*   88 */     _os_.marshal(this.mapid);
/*   89 */     _os_.marshal(this.iscouple);
/*   90 */     _os_.marshal(this.partenerroleid);
/*   91 */     _os_.marshal(this.groupid);
/*   92 */     _os_.marshal(this.sessionid);
/*   93 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*   99 */     _xdb_verify_unsafe_();
/*  100 */     this.invitetime = _os_.unmarshal_long();
/*  101 */     this.mapid = _os_.unmarshal_int();
/*  102 */     this.iscouple = _os_.unmarshal_boolean();
/*  103 */     this.partenerroleid = _os_.unmarshal_long();
/*  104 */     this.groupid = _os_.unmarshal_long();
/*  105 */     this.sessionid = _os_.unmarshal_long();
/*  106 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  112 */     _xdb_verify_unsafe_();
/*  113 */     int _size_ = 0;
/*  114 */     _size_ += CodedOutputStream.computeInt64Size(1, this.invitetime);
/*  115 */     _size_ += CodedOutputStream.computeInt32Size(2, this.mapid);
/*  116 */     _size_ += CodedOutputStream.computeBoolSize(3, this.iscouple);
/*  117 */     _size_ += CodedOutputStream.computeInt64Size(4, this.partenerroleid);
/*  118 */     _size_ += CodedOutputStream.computeInt64Size(5, this.groupid);
/*  119 */     _size_ += CodedOutputStream.computeInt64Size(6, this.sessionid);
/*  120 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  126 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  129 */       _output_.writeInt64(1, this.invitetime);
/*  130 */       _output_.writeInt32(2, this.mapid);
/*  131 */       _output_.writeBool(3, this.iscouple);
/*  132 */       _output_.writeInt64(4, this.partenerroleid);
/*  133 */       _output_.writeInt64(5, this.groupid);
/*  134 */       _output_.writeInt64(6, this.sessionid);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  138 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  140 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  146 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  149 */       boolean done = false;
/*  150 */       while (!done)
/*      */       {
/*  152 */         int tag = _input_.readTag();
/*  153 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  157 */           done = true;
/*  158 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  162 */           this.invitetime = _input_.readInt64();
/*  163 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  167 */           this.mapid = _input_.readInt32();
/*  168 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  172 */           this.iscouple = _input_.readBool();
/*  173 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  177 */           this.partenerroleid = _input_.readInt64();
/*  178 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  182 */           this.groupid = _input_.readInt64();
/*  183 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  187 */           this.sessionid = _input_.readInt64();
/*  188 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  192 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  194 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  203 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  207 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  209 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Watchmoon copy()
/*      */   {
/*  215 */     _xdb_verify_unsafe_();
/*  216 */     return new Watchmoon(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Watchmoon toData()
/*      */   {
/*  222 */     _xdb_verify_unsafe_();
/*  223 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Watchmoon toBean()
/*      */   {
/*  228 */     _xdb_verify_unsafe_();
/*  229 */     return new Watchmoon(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Watchmoon toDataIf()
/*      */   {
/*  235 */     _xdb_verify_unsafe_();
/*  236 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Watchmoon toBeanIf()
/*      */   {
/*  241 */     _xdb_verify_unsafe_();
/*  242 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  248 */     _xdb_verify_unsafe_();
/*  249 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getInvitetime()
/*      */   {
/*  256 */     _xdb_verify_unsafe_();
/*  257 */     return this.invitetime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMapid()
/*      */   {
/*  264 */     _xdb_verify_unsafe_();
/*  265 */     return this.mapid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIscouple()
/*      */   {
/*  272 */     _xdb_verify_unsafe_();
/*  273 */     return this.iscouple;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getPartenerroleid()
/*      */   {
/*  280 */     _xdb_verify_unsafe_();
/*  281 */     return this.partenerroleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getGroupid()
/*      */   {
/*  288 */     _xdb_verify_unsafe_();
/*  289 */     return this.groupid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getSessionid()
/*      */   {
/*  296 */     _xdb_verify_unsafe_();
/*  297 */     return this.sessionid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setInvitetime(long _v_)
/*      */   {
/*  304 */     _xdb_verify_unsafe_();
/*  305 */     Logs.logIf(new LogKey(this, "invitetime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  309 */         new LogLong(this, Watchmoon.this.invitetime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  313 */             Watchmoon.this.invitetime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  317 */     });
/*  318 */     this.invitetime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMapid(int _v_)
/*      */   {
/*  325 */     _xdb_verify_unsafe_();
/*  326 */     Logs.logIf(new LogKey(this, "mapid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  330 */         new xdb.logs.LogInt(this, Watchmoon.this.mapid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  334 */             Watchmoon.this.mapid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  338 */     });
/*  339 */     this.mapid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIscouple(boolean _v_)
/*      */   {
/*  346 */     _xdb_verify_unsafe_();
/*  347 */     Logs.logIf(new LogKey(this, "iscouple")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  351 */         new xdb.logs.LogObject(this, Boolean.valueOf(Watchmoon.this.iscouple))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  355 */             Watchmoon.this.iscouple = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  359 */     });
/*  360 */     this.iscouple = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPartenerroleid(long _v_)
/*      */   {
/*  367 */     _xdb_verify_unsafe_();
/*  368 */     Logs.logIf(new LogKey(this, "partenerroleid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  372 */         new LogLong(this, Watchmoon.this.partenerroleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  376 */             Watchmoon.this.partenerroleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  380 */     });
/*  381 */     this.partenerroleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGroupid(long _v_)
/*      */   {
/*  388 */     _xdb_verify_unsafe_();
/*  389 */     Logs.logIf(new LogKey(this, "groupid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  393 */         new LogLong(this, Watchmoon.this.groupid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  397 */             Watchmoon.this.groupid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  401 */     });
/*  402 */     this.groupid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSessionid(long _v_)
/*      */   {
/*  409 */     _xdb_verify_unsafe_();
/*  410 */     Logs.logIf(new LogKey(this, "sessionid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  414 */         new LogLong(this, Watchmoon.this.sessionid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  418 */             Watchmoon.this.sessionid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  422 */     });
/*  423 */     this.sessionid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  429 */     _xdb_verify_unsafe_();
/*  430 */     Watchmoon _o_ = null;
/*  431 */     if ((_o1_ instanceof Watchmoon)) { _o_ = (Watchmoon)_o1_;
/*  432 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  433 */       return false;
/*  434 */     if (this.invitetime != _o_.invitetime) return false;
/*  435 */     if (this.mapid != _o_.mapid) return false;
/*  436 */     if (this.iscouple != _o_.iscouple) return false;
/*  437 */     if (this.partenerroleid != _o_.partenerroleid) return false;
/*  438 */     if (this.groupid != _o_.groupid) return false;
/*  439 */     if (this.sessionid != _o_.sessionid) return false;
/*  440 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  446 */     _xdb_verify_unsafe_();
/*  447 */     int _h_ = 0;
/*  448 */     _h_ = (int)(_h_ + this.invitetime);
/*  449 */     _h_ += this.mapid;
/*  450 */     _h_ += (this.iscouple ? 1231 : 1237);
/*  451 */     _h_ = (int)(_h_ + this.partenerroleid);
/*  452 */     _h_ = (int)(_h_ + this.groupid);
/*  453 */     _h_ = (int)(_h_ + this.sessionid);
/*  454 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  460 */     _xdb_verify_unsafe_();
/*  461 */     StringBuilder _sb_ = new StringBuilder();
/*  462 */     _sb_.append("(");
/*  463 */     _sb_.append(this.invitetime);
/*  464 */     _sb_.append(",");
/*  465 */     _sb_.append(this.mapid);
/*  466 */     _sb_.append(",");
/*  467 */     _sb_.append(this.iscouple);
/*  468 */     _sb_.append(",");
/*  469 */     _sb_.append(this.partenerroleid);
/*  470 */     _sb_.append(",");
/*  471 */     _sb_.append(this.groupid);
/*  472 */     _sb_.append(",");
/*  473 */     _sb_.append(this.sessionid);
/*  474 */     _sb_.append(")");
/*  475 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  481 */     ListenableBean lb = new ListenableBean();
/*  482 */     lb.add(new ListenableChanged().setVarName("invitetime"));
/*  483 */     lb.add(new ListenableChanged().setVarName("mapid"));
/*  484 */     lb.add(new ListenableChanged().setVarName("iscouple"));
/*  485 */     lb.add(new ListenableChanged().setVarName("partenerroleid"));
/*  486 */     lb.add(new ListenableChanged().setVarName("groupid"));
/*  487 */     lb.add(new ListenableChanged().setVarName("sessionid"));
/*  488 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Watchmoon {
/*      */     private Const() {}
/*      */     
/*      */     Watchmoon nThis() {
/*  495 */       return Watchmoon.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  501 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Watchmoon copy()
/*      */     {
/*  507 */       return Watchmoon.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Watchmoon toData()
/*      */     {
/*  513 */       return Watchmoon.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Watchmoon toBean()
/*      */     {
/*  518 */       return Watchmoon.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Watchmoon toDataIf()
/*      */     {
/*  524 */       return Watchmoon.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Watchmoon toBeanIf()
/*      */     {
/*  529 */       return Watchmoon.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInvitetime()
/*      */     {
/*  536 */       Watchmoon.this._xdb_verify_unsafe_();
/*  537 */       return Watchmoon.this.invitetime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMapid()
/*      */     {
/*  544 */       Watchmoon.this._xdb_verify_unsafe_();
/*  545 */       return Watchmoon.this.mapid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIscouple()
/*      */     {
/*  552 */       Watchmoon.this._xdb_verify_unsafe_();
/*  553 */       return Watchmoon.this.iscouple;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getPartenerroleid()
/*      */     {
/*  560 */       Watchmoon.this._xdb_verify_unsafe_();
/*  561 */       return Watchmoon.this.partenerroleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGroupid()
/*      */     {
/*  568 */       Watchmoon.this._xdb_verify_unsafe_();
/*  569 */       return Watchmoon.this.groupid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSessionid()
/*      */     {
/*  576 */       Watchmoon.this._xdb_verify_unsafe_();
/*  577 */       return Watchmoon.this.sessionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInvitetime(long _v_)
/*      */     {
/*  584 */       Watchmoon.this._xdb_verify_unsafe_();
/*  585 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMapid(int _v_)
/*      */     {
/*  592 */       Watchmoon.this._xdb_verify_unsafe_();
/*  593 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIscouple(boolean _v_)
/*      */     {
/*  600 */       Watchmoon.this._xdb_verify_unsafe_();
/*  601 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPartenerroleid(long _v_)
/*      */     {
/*  608 */       Watchmoon.this._xdb_verify_unsafe_();
/*  609 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGroupid(long _v_)
/*      */     {
/*  616 */       Watchmoon.this._xdb_verify_unsafe_();
/*  617 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSessionid(long _v_)
/*      */     {
/*  624 */       Watchmoon.this._xdb_verify_unsafe_();
/*  625 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  631 */       Watchmoon.this._xdb_verify_unsafe_();
/*  632 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  638 */       Watchmoon.this._xdb_verify_unsafe_();
/*  639 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  645 */       return Watchmoon.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  651 */       return Watchmoon.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  657 */       Watchmoon.this._xdb_verify_unsafe_();
/*  658 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  664 */       return Watchmoon.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  670 */       return Watchmoon.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  676 */       Watchmoon.this._xdb_verify_unsafe_();
/*  677 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  683 */       return Watchmoon.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  689 */       return Watchmoon.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  695 */       return Watchmoon.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  701 */       return Watchmoon.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  707 */       return Watchmoon.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  713 */       return Watchmoon.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  719 */       return Watchmoon.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Watchmoon
/*      */   {
/*      */     private long invitetime;
/*      */     
/*      */     private int mapid;
/*      */     
/*      */     private boolean iscouple;
/*      */     
/*      */     private long partenerroleid;
/*      */     
/*      */     private long groupid;
/*      */     
/*      */     private long sessionid;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  741 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  746 */       this.invitetime = -1L;
/*  747 */       this.iscouple = false;
/*      */     }
/*      */     
/*      */     Data(xbean.Watchmoon _o1_)
/*      */     {
/*  752 */       if ((_o1_ instanceof Watchmoon)) { assign((Watchmoon)_o1_);
/*  753 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  754 */       } else if ((_o1_ instanceof Watchmoon.Const)) assign(((Watchmoon.Const)_o1_).nThis()); else {
/*  755 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Watchmoon _o_) {
/*  760 */       this.invitetime = _o_.invitetime;
/*  761 */       this.mapid = _o_.mapid;
/*  762 */       this.iscouple = _o_.iscouple;
/*  763 */       this.partenerroleid = _o_.partenerroleid;
/*  764 */       this.groupid = _o_.groupid;
/*  765 */       this.sessionid = _o_.sessionid;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  770 */       this.invitetime = _o_.invitetime;
/*  771 */       this.mapid = _o_.mapid;
/*  772 */       this.iscouple = _o_.iscouple;
/*  773 */       this.partenerroleid = _o_.partenerroleid;
/*  774 */       this.groupid = _o_.groupid;
/*  775 */       this.sessionid = _o_.sessionid;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  781 */       _os_.marshal(this.invitetime);
/*  782 */       _os_.marshal(this.mapid);
/*  783 */       _os_.marshal(this.iscouple);
/*  784 */       _os_.marshal(this.partenerroleid);
/*  785 */       _os_.marshal(this.groupid);
/*  786 */       _os_.marshal(this.sessionid);
/*  787 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  793 */       this.invitetime = _os_.unmarshal_long();
/*  794 */       this.mapid = _os_.unmarshal_int();
/*  795 */       this.iscouple = _os_.unmarshal_boolean();
/*  796 */       this.partenerroleid = _os_.unmarshal_long();
/*  797 */       this.groupid = _os_.unmarshal_long();
/*  798 */       this.sessionid = _os_.unmarshal_long();
/*  799 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  805 */       int _size_ = 0;
/*  806 */       _size_ += CodedOutputStream.computeInt64Size(1, this.invitetime);
/*  807 */       _size_ += CodedOutputStream.computeInt32Size(2, this.mapid);
/*  808 */       _size_ += CodedOutputStream.computeBoolSize(3, this.iscouple);
/*  809 */       _size_ += CodedOutputStream.computeInt64Size(4, this.partenerroleid);
/*  810 */       _size_ += CodedOutputStream.computeInt64Size(5, this.groupid);
/*  811 */       _size_ += CodedOutputStream.computeInt64Size(6, this.sessionid);
/*  812 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  820 */         _output_.writeInt64(1, this.invitetime);
/*  821 */         _output_.writeInt32(2, this.mapid);
/*  822 */         _output_.writeBool(3, this.iscouple);
/*  823 */         _output_.writeInt64(4, this.partenerroleid);
/*  824 */         _output_.writeInt64(5, this.groupid);
/*  825 */         _output_.writeInt64(6, this.sessionid);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  829 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  831 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  839 */         boolean done = false;
/*  840 */         while (!done)
/*      */         {
/*  842 */           int tag = _input_.readTag();
/*  843 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  847 */             done = true;
/*  848 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  852 */             this.invitetime = _input_.readInt64();
/*  853 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  857 */             this.mapid = _input_.readInt32();
/*  858 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  862 */             this.iscouple = _input_.readBool();
/*  863 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  867 */             this.partenerroleid = _input_.readInt64();
/*  868 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  872 */             this.groupid = _input_.readInt64();
/*  873 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  877 */             this.sessionid = _input_.readInt64();
/*  878 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  882 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  884 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  893 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  897 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  899 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Watchmoon copy()
/*      */     {
/*  905 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Watchmoon toData()
/*      */     {
/*  911 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Watchmoon toBean()
/*      */     {
/*  916 */       return new Watchmoon(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Watchmoon toDataIf()
/*      */     {
/*  922 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Watchmoon toBeanIf()
/*      */     {
/*  927 */       return new Watchmoon(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  933 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/*  937 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  941 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  945 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/*  949 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  953 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  957 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInvitetime()
/*      */     {
/*  964 */       return this.invitetime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMapid()
/*      */     {
/*  971 */       return this.mapid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIscouple()
/*      */     {
/*  978 */       return this.iscouple;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getPartenerroleid()
/*      */     {
/*  985 */       return this.partenerroleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGroupid()
/*      */     {
/*  992 */       return this.groupid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSessionid()
/*      */     {
/*  999 */       return this.sessionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInvitetime(long _v_)
/*      */     {
/* 1006 */       this.invitetime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMapid(int _v_)
/*      */     {
/* 1013 */       this.mapid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIscouple(boolean _v_)
/*      */     {
/* 1020 */       this.iscouple = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPartenerroleid(long _v_)
/*      */     {
/* 1027 */       this.partenerroleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGroupid(long _v_)
/*      */     {
/* 1034 */       this.groupid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSessionid(long _v_)
/*      */     {
/* 1041 */       this.sessionid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1047 */       if (!(_o1_ instanceof Data)) return false;
/* 1048 */       Data _o_ = (Data)_o1_;
/* 1049 */       if (this.invitetime != _o_.invitetime) return false;
/* 1050 */       if (this.mapid != _o_.mapid) return false;
/* 1051 */       if (this.iscouple != _o_.iscouple) return false;
/* 1052 */       if (this.partenerroleid != _o_.partenerroleid) return false;
/* 1053 */       if (this.groupid != _o_.groupid) return false;
/* 1054 */       if (this.sessionid != _o_.sessionid) return false;
/* 1055 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1061 */       int _h_ = 0;
/* 1062 */       _h_ = (int)(_h_ + this.invitetime);
/* 1063 */       _h_ += this.mapid;
/* 1064 */       _h_ += (this.iscouple ? 1231 : 1237);
/* 1065 */       _h_ = (int)(_h_ + this.partenerroleid);
/* 1066 */       _h_ = (int)(_h_ + this.groupid);
/* 1067 */       _h_ = (int)(_h_ + this.sessionid);
/* 1068 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1074 */       StringBuilder _sb_ = new StringBuilder();
/* 1075 */       _sb_.append("(");
/* 1076 */       _sb_.append(this.invitetime);
/* 1077 */       _sb_.append(",");
/* 1078 */       _sb_.append(this.mapid);
/* 1079 */       _sb_.append(",");
/* 1080 */       _sb_.append(this.iscouple);
/* 1081 */       _sb_.append(",");
/* 1082 */       _sb_.append(this.partenerroleid);
/* 1083 */       _sb_.append(",");
/* 1084 */       _sb_.append(this.groupid);
/* 1085 */       _sb_.append(",");
/* 1086 */       _sb_.append(this.sessionid);
/* 1087 */       _sb_.append(")");
/* 1088 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Watchmoon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */