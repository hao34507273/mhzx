/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import ppbio.ByteString;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class MenPaiStarChartInfo extends XBean implements xbean.MenPaiStarChartInfo
/*      */ {
/*      */   private long roleid;
/*      */   private String role_name;
/*      */   private int point;
/*      */   private int occupationid;
/*      */   private long update_point_time;
/*      */   private int status;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.roleid = 0L;
/*   29 */     this.role_name = "";
/*   30 */     this.point = 0;
/*   31 */     this.occupationid = 0;
/*   32 */     this.update_point_time = 0L;
/*   33 */     this.status = 0;
/*      */   }
/*      */   
/*      */   MenPaiStarChartInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.role_name = "";
/*      */   }
/*      */   
/*      */   public MenPaiStarChartInfo()
/*      */   {
/*   44 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public MenPaiStarChartInfo(MenPaiStarChartInfo _o_)
/*      */   {
/*   49 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   MenPaiStarChartInfo(xbean.MenPaiStarChartInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   54 */     super(_xp_, _vn_);
/*   55 */     if ((_o1_ instanceof MenPaiStarChartInfo)) { assign((MenPaiStarChartInfo)_o1_);
/*   56 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   57 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   58 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(MenPaiStarChartInfo _o_) {
/*   63 */     _o_._xdb_verify_unsafe_();
/*   64 */     this.roleid = _o_.roleid;
/*   65 */     this.role_name = _o_.role_name;
/*   66 */     this.point = _o_.point;
/*   67 */     this.occupationid = _o_.occupationid;
/*   68 */     this.update_point_time = _o_.update_point_time;
/*   69 */     this.status = _o_.status;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   74 */     this.roleid = _o_.roleid;
/*   75 */     this.role_name = _o_.role_name;
/*   76 */     this.point = _o_.point;
/*   77 */     this.occupationid = _o_.occupationid;
/*   78 */     this.update_point_time = _o_.update_point_time;
/*   79 */     this.status = _o_.status;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   85 */     _xdb_verify_unsafe_();
/*   86 */     _os_.marshal(this.roleid);
/*   87 */     _os_.marshal(this.role_name, "UTF-16LE");
/*   88 */     _os_.marshal(this.point);
/*   89 */     _os_.marshal(this.occupationid);
/*   90 */     _os_.marshal(this.update_point_time);
/*   91 */     _os_.marshal(this.status);
/*   92 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*   98 */     _xdb_verify_unsafe_();
/*   99 */     this.roleid = _os_.unmarshal_long();
/*  100 */     this.role_name = _os_.unmarshal_String("UTF-16LE");
/*  101 */     this.point = _os_.unmarshal_int();
/*  102 */     this.occupationid = _os_.unmarshal_int();
/*  103 */     this.update_point_time = _os_.unmarshal_long();
/*  104 */     this.status = _os_.unmarshal_int();
/*  105 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  111 */     _xdb_verify_unsafe_();
/*  112 */     int _size_ = 0;
/*  113 */     _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/*      */     try
/*      */     {
/*  116 */       _size_ += CodedOutputStream.computeBytesSize(2, ByteString.copyFrom(this.role_name, "UTF-16LE"));
/*      */     }
/*      */     catch (java.io.UnsupportedEncodingException e)
/*      */     {
/*  120 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  122 */     _size_ += CodedOutputStream.computeInt32Size(3, this.point);
/*  123 */     _size_ += CodedOutputStream.computeInt32Size(4, this.occupationid);
/*  124 */     _size_ += CodedOutputStream.computeInt64Size(5, this.update_point_time);
/*  125 */     _size_ += CodedOutputStream.computeInt32Size(6, this.status);
/*  126 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  132 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  135 */       _output_.writeInt64(1, this.roleid);
/*  136 */       _output_.writeBytes(2, ByteString.copyFrom(this.role_name, "UTF-16LE"));
/*  137 */       _output_.writeInt32(3, this.point);
/*  138 */       _output_.writeInt32(4, this.occupationid);
/*  139 */       _output_.writeInt64(5, this.update_point_time);
/*  140 */       _output_.writeInt32(6, this.status);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  144 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  146 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  152 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  155 */       boolean done = false;
/*  156 */       while (!done)
/*      */       {
/*  158 */         int tag = _input_.readTag();
/*  159 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  163 */           done = true;
/*  164 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  168 */           this.roleid = _input_.readInt64();
/*  169 */           break;
/*      */         
/*      */ 
/*      */         case 18: 
/*  173 */           this.role_name = _input_.readBytes().toString("UTF-16LE");
/*  174 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  178 */           this.point = _input_.readInt32();
/*  179 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  183 */           this.occupationid = _input_.readInt32();
/*  184 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  188 */           this.update_point_time = _input_.readInt64();
/*  189 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  193 */           this.status = _input_.readInt32();
/*  194 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  198 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  200 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  209 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  213 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  215 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MenPaiStarChartInfo copy()
/*      */   {
/*  221 */     _xdb_verify_unsafe_();
/*  222 */     return new MenPaiStarChartInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MenPaiStarChartInfo toData()
/*      */   {
/*  228 */     _xdb_verify_unsafe_();
/*  229 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MenPaiStarChartInfo toBean()
/*      */   {
/*  234 */     _xdb_verify_unsafe_();
/*  235 */     return new MenPaiStarChartInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MenPaiStarChartInfo toDataIf()
/*      */   {
/*  241 */     _xdb_verify_unsafe_();
/*  242 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MenPaiStarChartInfo toBeanIf()
/*      */   {
/*  247 */     _xdb_verify_unsafe_();
/*  248 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  254 */     _xdb_verify_unsafe_();
/*  255 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRoleid()
/*      */   {
/*  262 */     _xdb_verify_unsafe_();
/*  263 */     return this.roleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getRole_name()
/*      */   {
/*  270 */     _xdb_verify_unsafe_();
/*  271 */     return this.role_name;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getRole_nameOctets()
/*      */   {
/*  278 */     _xdb_verify_unsafe_();
/*  279 */     return Octets.wrap(getRole_name(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPoint()
/*      */   {
/*  286 */     _xdb_verify_unsafe_();
/*  287 */     return this.point;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getOccupationid()
/*      */   {
/*  294 */     _xdb_verify_unsafe_();
/*  295 */     return this.occupationid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getUpdate_point_time()
/*      */   {
/*  302 */     _xdb_verify_unsafe_();
/*  303 */     return this.update_point_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getStatus()
/*      */   {
/*  310 */     _xdb_verify_unsafe_();
/*  311 */     return this.status;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRoleid(long _v_)
/*      */   {
/*  318 */     _xdb_verify_unsafe_();
/*  319 */     xdb.Logs.logIf(new LogKey(this, "roleid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  323 */         new xdb.logs.LogLong(this, MenPaiStarChartInfo.this.roleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  327 */             MenPaiStarChartInfo.this.roleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  331 */     });
/*  332 */     this.roleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRole_name(String _v_)
/*      */   {
/*  339 */     _xdb_verify_unsafe_();
/*  340 */     if (null == _v_)
/*  341 */       throw new NullPointerException();
/*  342 */     xdb.Logs.logIf(new LogKey(this, "role_name")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  346 */         new xdb.logs.LogString(this, MenPaiStarChartInfo.this.role_name)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  350 */             MenPaiStarChartInfo.this.role_name = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  354 */     });
/*  355 */     this.role_name = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRole_nameOctets(Octets _v_)
/*      */   {
/*  362 */     _xdb_verify_unsafe_();
/*  363 */     setRole_name(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPoint(int _v_)
/*      */   {
/*  370 */     _xdb_verify_unsafe_();
/*  371 */     xdb.Logs.logIf(new LogKey(this, "point")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  375 */         new LogInt(this, MenPaiStarChartInfo.this.point)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  379 */             MenPaiStarChartInfo.this.point = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  383 */     });
/*  384 */     this.point = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOccupationid(int _v_)
/*      */   {
/*  391 */     _xdb_verify_unsafe_();
/*  392 */     xdb.Logs.logIf(new LogKey(this, "occupationid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  396 */         new LogInt(this, MenPaiStarChartInfo.this.occupationid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  400 */             MenPaiStarChartInfo.this.occupationid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  404 */     });
/*  405 */     this.occupationid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setUpdate_point_time(long _v_)
/*      */   {
/*  412 */     _xdb_verify_unsafe_();
/*  413 */     xdb.Logs.logIf(new LogKey(this, "update_point_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  417 */         new xdb.logs.LogLong(this, MenPaiStarChartInfo.this.update_point_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  421 */             MenPaiStarChartInfo.this.update_point_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  425 */     });
/*  426 */     this.update_point_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStatus(int _v_)
/*      */   {
/*  433 */     _xdb_verify_unsafe_();
/*  434 */     xdb.Logs.logIf(new LogKey(this, "status")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  438 */         new LogInt(this, MenPaiStarChartInfo.this.status)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  442 */             MenPaiStarChartInfo.this.status = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  446 */     });
/*  447 */     this.status = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  453 */     _xdb_verify_unsafe_();
/*  454 */     MenPaiStarChartInfo _o_ = null;
/*  455 */     if ((_o1_ instanceof MenPaiStarChartInfo)) { _o_ = (MenPaiStarChartInfo)_o1_;
/*  456 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  457 */       return false;
/*  458 */     if (this.roleid != _o_.roleid) return false;
/*  459 */     if (!this.role_name.equals(_o_.role_name)) return false;
/*  460 */     if (this.point != _o_.point) return false;
/*  461 */     if (this.occupationid != _o_.occupationid) return false;
/*  462 */     if (this.update_point_time != _o_.update_point_time) return false;
/*  463 */     if (this.status != _o_.status) return false;
/*  464 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  470 */     _xdb_verify_unsafe_();
/*  471 */     int _h_ = 0;
/*  472 */     _h_ = (int)(_h_ + this.roleid);
/*  473 */     _h_ += this.role_name.hashCode();
/*  474 */     _h_ += this.point;
/*  475 */     _h_ += this.occupationid;
/*  476 */     _h_ = (int)(_h_ + this.update_point_time);
/*  477 */     _h_ += this.status;
/*  478 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  484 */     _xdb_verify_unsafe_();
/*  485 */     StringBuilder _sb_ = new StringBuilder();
/*  486 */     _sb_.append("(");
/*  487 */     _sb_.append(this.roleid);
/*  488 */     _sb_.append(",");
/*  489 */     _sb_.append("'").append(this.role_name).append("'");
/*  490 */     _sb_.append(",");
/*  491 */     _sb_.append(this.point);
/*  492 */     _sb_.append(",");
/*  493 */     _sb_.append(this.occupationid);
/*  494 */     _sb_.append(",");
/*  495 */     _sb_.append(this.update_point_time);
/*  496 */     _sb_.append(",");
/*  497 */     _sb_.append(this.status);
/*  498 */     _sb_.append(")");
/*  499 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  505 */     ListenableBean lb = new ListenableBean();
/*  506 */     lb.add(new ListenableChanged().setVarName("roleid"));
/*  507 */     lb.add(new ListenableChanged().setVarName("role_name"));
/*  508 */     lb.add(new ListenableChanged().setVarName("point"));
/*  509 */     lb.add(new ListenableChanged().setVarName("occupationid"));
/*  510 */     lb.add(new ListenableChanged().setVarName("update_point_time"));
/*  511 */     lb.add(new ListenableChanged().setVarName("status"));
/*  512 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.MenPaiStarChartInfo {
/*      */     private Const() {}
/*      */     
/*      */     MenPaiStarChartInfo nThis() {
/*  519 */       return MenPaiStarChartInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  525 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MenPaiStarChartInfo copy()
/*      */     {
/*  531 */       return MenPaiStarChartInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MenPaiStarChartInfo toData()
/*      */     {
/*  537 */       return MenPaiStarChartInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.MenPaiStarChartInfo toBean()
/*      */     {
/*  542 */       return MenPaiStarChartInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MenPaiStarChartInfo toDataIf()
/*      */     {
/*  548 */       return MenPaiStarChartInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.MenPaiStarChartInfo toBeanIf()
/*      */     {
/*  553 */       return MenPaiStarChartInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/*  560 */       MenPaiStarChartInfo.this._xdb_verify_unsafe_();
/*  561 */       return MenPaiStarChartInfo.this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getRole_name()
/*      */     {
/*  568 */       MenPaiStarChartInfo.this._xdb_verify_unsafe_();
/*  569 */       return MenPaiStarChartInfo.this.role_name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getRole_nameOctets()
/*      */     {
/*  576 */       MenPaiStarChartInfo.this._xdb_verify_unsafe_();
/*  577 */       return MenPaiStarChartInfo.this.getRole_nameOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPoint()
/*      */     {
/*  584 */       MenPaiStarChartInfo.this._xdb_verify_unsafe_();
/*  585 */       return MenPaiStarChartInfo.this.point;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOccupationid()
/*      */     {
/*  592 */       MenPaiStarChartInfo.this._xdb_verify_unsafe_();
/*  593 */       return MenPaiStarChartInfo.this.occupationid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getUpdate_point_time()
/*      */     {
/*  600 */       MenPaiStarChartInfo.this._xdb_verify_unsafe_();
/*  601 */       return MenPaiStarChartInfo.this.update_point_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStatus()
/*      */     {
/*  608 */       MenPaiStarChartInfo.this._xdb_verify_unsafe_();
/*  609 */       return MenPaiStarChartInfo.this.status;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/*  616 */       MenPaiStarChartInfo.this._xdb_verify_unsafe_();
/*  617 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRole_name(String _v_)
/*      */     {
/*  624 */       MenPaiStarChartInfo.this._xdb_verify_unsafe_();
/*  625 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRole_nameOctets(Octets _v_)
/*      */     {
/*  632 */       MenPaiStarChartInfo.this._xdb_verify_unsafe_();
/*  633 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPoint(int _v_)
/*      */     {
/*  640 */       MenPaiStarChartInfo.this._xdb_verify_unsafe_();
/*  641 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOccupationid(int _v_)
/*      */     {
/*  648 */       MenPaiStarChartInfo.this._xdb_verify_unsafe_();
/*  649 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUpdate_point_time(long _v_)
/*      */     {
/*  656 */       MenPaiStarChartInfo.this._xdb_verify_unsafe_();
/*  657 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStatus(int _v_)
/*      */     {
/*  664 */       MenPaiStarChartInfo.this._xdb_verify_unsafe_();
/*  665 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  671 */       MenPaiStarChartInfo.this._xdb_verify_unsafe_();
/*  672 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  678 */       MenPaiStarChartInfo.this._xdb_verify_unsafe_();
/*  679 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  685 */       return MenPaiStarChartInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  691 */       return MenPaiStarChartInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  697 */       MenPaiStarChartInfo.this._xdb_verify_unsafe_();
/*  698 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  704 */       return MenPaiStarChartInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  710 */       return MenPaiStarChartInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  716 */       MenPaiStarChartInfo.this._xdb_verify_unsafe_();
/*  717 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  723 */       return MenPaiStarChartInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  729 */       return MenPaiStarChartInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  735 */       return MenPaiStarChartInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  741 */       return MenPaiStarChartInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  747 */       return MenPaiStarChartInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  753 */       return MenPaiStarChartInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  759 */       return MenPaiStarChartInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.MenPaiStarChartInfo
/*      */   {
/*      */     private long roleid;
/*      */     
/*      */     private String role_name;
/*      */     
/*      */     private int point;
/*      */     
/*      */     private int occupationid;
/*      */     
/*      */     private long update_point_time;
/*      */     
/*      */     private int status;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  781 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  786 */       this.role_name = "";
/*      */     }
/*      */     
/*      */     Data(xbean.MenPaiStarChartInfo _o1_)
/*      */     {
/*  791 */       if ((_o1_ instanceof MenPaiStarChartInfo)) { assign((MenPaiStarChartInfo)_o1_);
/*  792 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  793 */       } else if ((_o1_ instanceof MenPaiStarChartInfo.Const)) assign(((MenPaiStarChartInfo.Const)_o1_).nThis()); else {
/*  794 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(MenPaiStarChartInfo _o_) {
/*  799 */       this.roleid = _o_.roleid;
/*  800 */       this.role_name = _o_.role_name;
/*  801 */       this.point = _o_.point;
/*  802 */       this.occupationid = _o_.occupationid;
/*  803 */       this.update_point_time = _o_.update_point_time;
/*  804 */       this.status = _o_.status;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  809 */       this.roleid = _o_.roleid;
/*  810 */       this.role_name = _o_.role_name;
/*  811 */       this.point = _o_.point;
/*  812 */       this.occupationid = _o_.occupationid;
/*  813 */       this.update_point_time = _o_.update_point_time;
/*  814 */       this.status = _o_.status;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  820 */       _os_.marshal(this.roleid);
/*  821 */       _os_.marshal(this.role_name, "UTF-16LE");
/*  822 */       _os_.marshal(this.point);
/*  823 */       _os_.marshal(this.occupationid);
/*  824 */       _os_.marshal(this.update_point_time);
/*  825 */       _os_.marshal(this.status);
/*  826 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  832 */       this.roleid = _os_.unmarshal_long();
/*  833 */       this.role_name = _os_.unmarshal_String("UTF-16LE");
/*  834 */       this.point = _os_.unmarshal_int();
/*  835 */       this.occupationid = _os_.unmarshal_int();
/*  836 */       this.update_point_time = _os_.unmarshal_long();
/*  837 */       this.status = _os_.unmarshal_int();
/*  838 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  844 */       int _size_ = 0;
/*  845 */       _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/*      */       try
/*      */       {
/*  848 */         _size_ += CodedOutputStream.computeBytesSize(2, ByteString.copyFrom(this.role_name, "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/*  852 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*  854 */       _size_ += CodedOutputStream.computeInt32Size(3, this.point);
/*  855 */       _size_ += CodedOutputStream.computeInt32Size(4, this.occupationid);
/*  856 */       _size_ += CodedOutputStream.computeInt64Size(5, this.update_point_time);
/*  857 */       _size_ += CodedOutputStream.computeInt32Size(6, this.status);
/*  858 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  866 */         _output_.writeInt64(1, this.roleid);
/*  867 */         _output_.writeBytes(2, ByteString.copyFrom(this.role_name, "UTF-16LE"));
/*  868 */         _output_.writeInt32(3, this.point);
/*  869 */         _output_.writeInt32(4, this.occupationid);
/*  870 */         _output_.writeInt64(5, this.update_point_time);
/*  871 */         _output_.writeInt32(6, this.status);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  875 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  877 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  885 */         boolean done = false;
/*  886 */         while (!done)
/*      */         {
/*  888 */           int tag = _input_.readTag();
/*  889 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  893 */             done = true;
/*  894 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  898 */             this.roleid = _input_.readInt64();
/*  899 */             break;
/*      */           
/*      */ 
/*      */           case 18: 
/*  903 */             this.role_name = _input_.readBytes().toString("UTF-16LE");
/*  904 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  908 */             this.point = _input_.readInt32();
/*  909 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  913 */             this.occupationid = _input_.readInt32();
/*  914 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  918 */             this.update_point_time = _input_.readInt64();
/*  919 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  923 */             this.status = _input_.readInt32();
/*  924 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  928 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  930 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  939 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  943 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  945 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MenPaiStarChartInfo copy()
/*      */     {
/*  951 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MenPaiStarChartInfo toData()
/*      */     {
/*  957 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.MenPaiStarChartInfo toBean()
/*      */     {
/*  962 */       return new MenPaiStarChartInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MenPaiStarChartInfo toDataIf()
/*      */     {
/*  968 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.MenPaiStarChartInfo toBeanIf()
/*      */     {
/*  973 */       return new MenPaiStarChartInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  979 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  983 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  987 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  991 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  995 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  999 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1003 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/* 1010 */       return this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getRole_name()
/*      */     {
/* 1017 */       return this.role_name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getRole_nameOctets()
/*      */     {
/* 1024 */       return Octets.wrap(getRole_name(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPoint()
/*      */     {
/* 1031 */       return this.point;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOccupationid()
/*      */     {
/* 1038 */       return this.occupationid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getUpdate_point_time()
/*      */     {
/* 1045 */       return this.update_point_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStatus()
/*      */     {
/* 1052 */       return this.status;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/* 1059 */       this.roleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRole_name(String _v_)
/*      */     {
/* 1066 */       if (null == _v_)
/* 1067 */         throw new NullPointerException();
/* 1068 */       this.role_name = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRole_nameOctets(Octets _v_)
/*      */     {
/* 1075 */       setRole_name(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPoint(int _v_)
/*      */     {
/* 1082 */       this.point = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOccupationid(int _v_)
/*      */     {
/* 1089 */       this.occupationid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUpdate_point_time(long _v_)
/*      */     {
/* 1096 */       this.update_point_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStatus(int _v_)
/*      */     {
/* 1103 */       this.status = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1109 */       if (!(_o1_ instanceof Data)) return false;
/* 1110 */       Data _o_ = (Data)_o1_;
/* 1111 */       if (this.roleid != _o_.roleid) return false;
/* 1112 */       if (!this.role_name.equals(_o_.role_name)) return false;
/* 1113 */       if (this.point != _o_.point) return false;
/* 1114 */       if (this.occupationid != _o_.occupationid) return false;
/* 1115 */       if (this.update_point_time != _o_.update_point_time) return false;
/* 1116 */       if (this.status != _o_.status) return false;
/* 1117 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1123 */       int _h_ = 0;
/* 1124 */       _h_ = (int)(_h_ + this.roleid);
/* 1125 */       _h_ += this.role_name.hashCode();
/* 1126 */       _h_ += this.point;
/* 1127 */       _h_ += this.occupationid;
/* 1128 */       _h_ = (int)(_h_ + this.update_point_time);
/* 1129 */       _h_ += this.status;
/* 1130 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1136 */       StringBuilder _sb_ = new StringBuilder();
/* 1137 */       _sb_.append("(");
/* 1138 */       _sb_.append(this.roleid);
/* 1139 */       _sb_.append(",");
/* 1140 */       _sb_.append("'").append(this.role_name).append("'");
/* 1141 */       _sb_.append(",");
/* 1142 */       _sb_.append(this.point);
/* 1143 */       _sb_.append(",");
/* 1144 */       _sb_.append(this.occupationid);
/* 1145 */       _sb_.append(",");
/* 1146 */       _sb_.append(this.update_point_time);
/* 1147 */       _sb_.append(",");
/* 1148 */       _sb_.append(this.status);
/* 1149 */       _sb_.append(")");
/* 1150 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MenPaiStarChartInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */