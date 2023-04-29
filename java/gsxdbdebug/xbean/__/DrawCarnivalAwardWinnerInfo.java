/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import ppbio.ByteString;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class DrawCarnivalAwardWinnerInfo extends XBean implements xbean.DrawCarnivalAwardWinnerInfo
/*      */ {
/*      */   private long role_id;
/*      */   private String role_name;
/*      */   private int random_type_id;
/*      */   private long award_count;
/*      */   private long award_time_stamp;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.role_id = 0L;
/*   27 */     this.role_name = "";
/*   28 */     this.random_type_id = 0;
/*   29 */     this.award_count = 0L;
/*   30 */     this.award_time_stamp = 0L;
/*      */   }
/*      */   
/*      */   DrawCarnivalAwardWinnerInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.role_name = "";
/*      */   }
/*      */   
/*      */   public DrawCarnivalAwardWinnerInfo()
/*      */   {
/*   41 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public DrawCarnivalAwardWinnerInfo(DrawCarnivalAwardWinnerInfo _o_)
/*      */   {
/*   46 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   DrawCarnivalAwardWinnerInfo(xbean.DrawCarnivalAwardWinnerInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   51 */     super(_xp_, _vn_);
/*   52 */     if ((_o1_ instanceof DrawCarnivalAwardWinnerInfo)) { assign((DrawCarnivalAwardWinnerInfo)_o1_);
/*   53 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   54 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   55 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(DrawCarnivalAwardWinnerInfo _o_) {
/*   60 */     _o_._xdb_verify_unsafe_();
/*   61 */     this.role_id = _o_.role_id;
/*   62 */     this.role_name = _o_.role_name;
/*   63 */     this.random_type_id = _o_.random_type_id;
/*   64 */     this.award_count = _o_.award_count;
/*   65 */     this.award_time_stamp = _o_.award_time_stamp;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   70 */     this.role_id = _o_.role_id;
/*   71 */     this.role_name = _o_.role_name;
/*   72 */     this.random_type_id = _o_.random_type_id;
/*   73 */     this.award_count = _o_.award_count;
/*   74 */     this.award_time_stamp = _o_.award_time_stamp;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   80 */     _xdb_verify_unsafe_();
/*   81 */     _os_.marshal(this.role_id);
/*   82 */     _os_.marshal(this.role_name, "UTF-16LE");
/*   83 */     _os_.marshal(this.random_type_id);
/*   84 */     _os_.marshal(this.award_count);
/*   85 */     _os_.marshal(this.award_time_stamp);
/*   86 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*   92 */     _xdb_verify_unsafe_();
/*   93 */     this.role_id = _os_.unmarshal_long();
/*   94 */     this.role_name = _os_.unmarshal_String("UTF-16LE");
/*   95 */     this.random_type_id = _os_.unmarshal_int();
/*   96 */     this.award_count = _os_.unmarshal_long();
/*   97 */     this.award_time_stamp = _os_.unmarshal_long();
/*   98 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  104 */     _xdb_verify_unsafe_();
/*  105 */     int _size_ = 0;
/*  106 */     _size_ += CodedOutputStream.computeInt64Size(1, this.role_id);
/*      */     try
/*      */     {
/*  109 */       _size_ += CodedOutputStream.computeBytesSize(2, ByteString.copyFrom(this.role_name, "UTF-16LE"));
/*      */     }
/*      */     catch (java.io.UnsupportedEncodingException e)
/*      */     {
/*  113 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  115 */     _size_ += CodedOutputStream.computeInt32Size(3, this.random_type_id);
/*  116 */     _size_ += CodedOutputStream.computeInt64Size(4, this.award_count);
/*  117 */     _size_ += CodedOutputStream.computeInt64Size(5, this.award_time_stamp);
/*  118 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  124 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  127 */       _output_.writeInt64(1, this.role_id);
/*  128 */       _output_.writeBytes(2, ByteString.copyFrom(this.role_name, "UTF-16LE"));
/*  129 */       _output_.writeInt32(3, this.random_type_id);
/*  130 */       _output_.writeInt64(4, this.award_count);
/*  131 */       _output_.writeInt64(5, this.award_time_stamp);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  135 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  137 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  143 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  146 */       boolean done = false;
/*  147 */       while (!done)
/*      */       {
/*  149 */         int tag = _input_.readTag();
/*  150 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  154 */           done = true;
/*  155 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  159 */           this.role_id = _input_.readInt64();
/*  160 */           break;
/*      */         
/*      */ 
/*      */         case 18: 
/*  164 */           this.role_name = _input_.readBytes().toString("UTF-16LE");
/*  165 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  169 */           this.random_type_id = _input_.readInt32();
/*  170 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  174 */           this.award_count = _input_.readInt64();
/*  175 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  179 */           this.award_time_stamp = _input_.readInt64();
/*  180 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  184 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  186 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  195 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  199 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  201 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.DrawCarnivalAwardWinnerInfo copy()
/*      */   {
/*  207 */     _xdb_verify_unsafe_();
/*  208 */     return new DrawCarnivalAwardWinnerInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.DrawCarnivalAwardWinnerInfo toData()
/*      */   {
/*  214 */     _xdb_verify_unsafe_();
/*  215 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.DrawCarnivalAwardWinnerInfo toBean()
/*      */   {
/*  220 */     _xdb_verify_unsafe_();
/*  221 */     return new DrawCarnivalAwardWinnerInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.DrawCarnivalAwardWinnerInfo toDataIf()
/*      */   {
/*  227 */     _xdb_verify_unsafe_();
/*  228 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.DrawCarnivalAwardWinnerInfo toBeanIf()
/*      */   {
/*  233 */     _xdb_verify_unsafe_();
/*  234 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  240 */     _xdb_verify_unsafe_();
/*  241 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRole_id()
/*      */   {
/*  248 */     _xdb_verify_unsafe_();
/*  249 */     return this.role_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getRole_name()
/*      */   {
/*  256 */     _xdb_verify_unsafe_();
/*  257 */     return this.role_name;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getRole_nameOctets()
/*      */   {
/*  264 */     _xdb_verify_unsafe_();
/*  265 */     return Octets.wrap(getRole_name(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRandom_type_id()
/*      */   {
/*  272 */     _xdb_verify_unsafe_();
/*  273 */     return this.random_type_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getAward_count()
/*      */   {
/*  280 */     _xdb_verify_unsafe_();
/*  281 */     return this.award_count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getAward_time_stamp()
/*      */   {
/*  288 */     _xdb_verify_unsafe_();
/*  289 */     return this.award_time_stamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRole_id(long _v_)
/*      */   {
/*  296 */     _xdb_verify_unsafe_();
/*  297 */     xdb.Logs.logIf(new LogKey(this, "role_id")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  301 */         new LogLong(this, DrawCarnivalAwardWinnerInfo.this.role_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  305 */             DrawCarnivalAwardWinnerInfo.this.role_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  309 */     });
/*  310 */     this.role_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRole_name(String _v_)
/*      */   {
/*  317 */     _xdb_verify_unsafe_();
/*  318 */     if (null == _v_)
/*  319 */       throw new NullPointerException();
/*  320 */     xdb.Logs.logIf(new LogKey(this, "role_name")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  324 */         new xdb.logs.LogString(this, DrawCarnivalAwardWinnerInfo.this.role_name)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  328 */             DrawCarnivalAwardWinnerInfo.this.role_name = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  332 */     });
/*  333 */     this.role_name = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRole_nameOctets(Octets _v_)
/*      */   {
/*  340 */     _xdb_verify_unsafe_();
/*  341 */     setRole_name(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRandom_type_id(int _v_)
/*      */   {
/*  348 */     _xdb_verify_unsafe_();
/*  349 */     xdb.Logs.logIf(new LogKey(this, "random_type_id")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  353 */         new xdb.logs.LogInt(this, DrawCarnivalAwardWinnerInfo.this.random_type_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  357 */             DrawCarnivalAwardWinnerInfo.this.random_type_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  361 */     });
/*  362 */     this.random_type_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAward_count(long _v_)
/*      */   {
/*  369 */     _xdb_verify_unsafe_();
/*  370 */     xdb.Logs.logIf(new LogKey(this, "award_count")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  374 */         new LogLong(this, DrawCarnivalAwardWinnerInfo.this.award_count)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  378 */             DrawCarnivalAwardWinnerInfo.this.award_count = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  382 */     });
/*  383 */     this.award_count = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAward_time_stamp(long _v_)
/*      */   {
/*  390 */     _xdb_verify_unsafe_();
/*  391 */     xdb.Logs.logIf(new LogKey(this, "award_time_stamp")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  395 */         new LogLong(this, DrawCarnivalAwardWinnerInfo.this.award_time_stamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  399 */             DrawCarnivalAwardWinnerInfo.this.award_time_stamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  403 */     });
/*  404 */     this.award_time_stamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  410 */     _xdb_verify_unsafe_();
/*  411 */     DrawCarnivalAwardWinnerInfo _o_ = null;
/*  412 */     if ((_o1_ instanceof DrawCarnivalAwardWinnerInfo)) { _o_ = (DrawCarnivalAwardWinnerInfo)_o1_;
/*  413 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  414 */       return false;
/*  415 */     if (this.role_id != _o_.role_id) return false;
/*  416 */     if (!this.role_name.equals(_o_.role_name)) return false;
/*  417 */     if (this.random_type_id != _o_.random_type_id) return false;
/*  418 */     if (this.award_count != _o_.award_count) return false;
/*  419 */     if (this.award_time_stamp != _o_.award_time_stamp) return false;
/*  420 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  426 */     _xdb_verify_unsafe_();
/*  427 */     int _h_ = 0;
/*  428 */     _h_ = (int)(_h_ + this.role_id);
/*  429 */     _h_ += this.role_name.hashCode();
/*  430 */     _h_ += this.random_type_id;
/*  431 */     _h_ = (int)(_h_ + this.award_count);
/*  432 */     _h_ = (int)(_h_ + this.award_time_stamp);
/*  433 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  439 */     _xdb_verify_unsafe_();
/*  440 */     StringBuilder _sb_ = new StringBuilder();
/*  441 */     _sb_.append("(");
/*  442 */     _sb_.append(this.role_id);
/*  443 */     _sb_.append(",");
/*  444 */     _sb_.append("'").append(this.role_name).append("'");
/*  445 */     _sb_.append(",");
/*  446 */     _sb_.append(this.random_type_id);
/*  447 */     _sb_.append(",");
/*  448 */     _sb_.append(this.award_count);
/*  449 */     _sb_.append(",");
/*  450 */     _sb_.append(this.award_time_stamp);
/*  451 */     _sb_.append(")");
/*  452 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  458 */     ListenableBean lb = new ListenableBean();
/*  459 */     lb.add(new ListenableChanged().setVarName("role_id"));
/*  460 */     lb.add(new ListenableChanged().setVarName("role_name"));
/*  461 */     lb.add(new ListenableChanged().setVarName("random_type_id"));
/*  462 */     lb.add(new ListenableChanged().setVarName("award_count"));
/*  463 */     lb.add(new ListenableChanged().setVarName("award_time_stamp"));
/*  464 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.DrawCarnivalAwardWinnerInfo {
/*      */     private Const() {}
/*      */     
/*      */     DrawCarnivalAwardWinnerInfo nThis() {
/*  471 */       return DrawCarnivalAwardWinnerInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  477 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DrawCarnivalAwardWinnerInfo copy()
/*      */     {
/*  483 */       return DrawCarnivalAwardWinnerInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DrawCarnivalAwardWinnerInfo toData()
/*      */     {
/*  489 */       return DrawCarnivalAwardWinnerInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.DrawCarnivalAwardWinnerInfo toBean()
/*      */     {
/*  494 */       return DrawCarnivalAwardWinnerInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DrawCarnivalAwardWinnerInfo toDataIf()
/*      */     {
/*  500 */       return DrawCarnivalAwardWinnerInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.DrawCarnivalAwardWinnerInfo toBeanIf()
/*      */     {
/*  505 */       return DrawCarnivalAwardWinnerInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRole_id()
/*      */     {
/*  512 */       DrawCarnivalAwardWinnerInfo.this._xdb_verify_unsafe_();
/*  513 */       return DrawCarnivalAwardWinnerInfo.this.role_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getRole_name()
/*      */     {
/*  520 */       DrawCarnivalAwardWinnerInfo.this._xdb_verify_unsafe_();
/*  521 */       return DrawCarnivalAwardWinnerInfo.this.role_name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getRole_nameOctets()
/*      */     {
/*  528 */       DrawCarnivalAwardWinnerInfo.this._xdb_verify_unsafe_();
/*  529 */       return DrawCarnivalAwardWinnerInfo.this.getRole_nameOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRandom_type_id()
/*      */     {
/*  536 */       DrawCarnivalAwardWinnerInfo.this._xdb_verify_unsafe_();
/*  537 */       return DrawCarnivalAwardWinnerInfo.this.random_type_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAward_count()
/*      */     {
/*  544 */       DrawCarnivalAwardWinnerInfo.this._xdb_verify_unsafe_();
/*  545 */       return DrawCarnivalAwardWinnerInfo.this.award_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAward_time_stamp()
/*      */     {
/*  552 */       DrawCarnivalAwardWinnerInfo.this._xdb_verify_unsafe_();
/*  553 */       return DrawCarnivalAwardWinnerInfo.this.award_time_stamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRole_id(long _v_)
/*      */     {
/*  560 */       DrawCarnivalAwardWinnerInfo.this._xdb_verify_unsafe_();
/*  561 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRole_name(String _v_)
/*      */     {
/*  568 */       DrawCarnivalAwardWinnerInfo.this._xdb_verify_unsafe_();
/*  569 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRole_nameOctets(Octets _v_)
/*      */     {
/*  576 */       DrawCarnivalAwardWinnerInfo.this._xdb_verify_unsafe_();
/*  577 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRandom_type_id(int _v_)
/*      */     {
/*  584 */       DrawCarnivalAwardWinnerInfo.this._xdb_verify_unsafe_();
/*  585 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAward_count(long _v_)
/*      */     {
/*  592 */       DrawCarnivalAwardWinnerInfo.this._xdb_verify_unsafe_();
/*  593 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAward_time_stamp(long _v_)
/*      */     {
/*  600 */       DrawCarnivalAwardWinnerInfo.this._xdb_verify_unsafe_();
/*  601 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  607 */       DrawCarnivalAwardWinnerInfo.this._xdb_verify_unsafe_();
/*  608 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  614 */       DrawCarnivalAwardWinnerInfo.this._xdb_verify_unsafe_();
/*  615 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  621 */       return DrawCarnivalAwardWinnerInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  627 */       return DrawCarnivalAwardWinnerInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  633 */       DrawCarnivalAwardWinnerInfo.this._xdb_verify_unsafe_();
/*  634 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  640 */       return DrawCarnivalAwardWinnerInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  646 */       return DrawCarnivalAwardWinnerInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  652 */       DrawCarnivalAwardWinnerInfo.this._xdb_verify_unsafe_();
/*  653 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  659 */       return DrawCarnivalAwardWinnerInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  665 */       return DrawCarnivalAwardWinnerInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  671 */       return DrawCarnivalAwardWinnerInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  677 */       return DrawCarnivalAwardWinnerInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  683 */       return DrawCarnivalAwardWinnerInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  689 */       return DrawCarnivalAwardWinnerInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  695 */       return DrawCarnivalAwardWinnerInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.DrawCarnivalAwardWinnerInfo
/*      */   {
/*      */     private long role_id;
/*      */     
/*      */     private String role_name;
/*      */     
/*      */     private int random_type_id;
/*      */     
/*      */     private long award_count;
/*      */     
/*      */     private long award_time_stamp;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  715 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  720 */       this.role_name = "";
/*      */     }
/*      */     
/*      */     Data(xbean.DrawCarnivalAwardWinnerInfo _o1_)
/*      */     {
/*  725 */       if ((_o1_ instanceof DrawCarnivalAwardWinnerInfo)) { assign((DrawCarnivalAwardWinnerInfo)_o1_);
/*  726 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  727 */       } else if ((_o1_ instanceof DrawCarnivalAwardWinnerInfo.Const)) assign(((DrawCarnivalAwardWinnerInfo.Const)_o1_).nThis()); else {
/*  728 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(DrawCarnivalAwardWinnerInfo _o_) {
/*  733 */       this.role_id = _o_.role_id;
/*  734 */       this.role_name = _o_.role_name;
/*  735 */       this.random_type_id = _o_.random_type_id;
/*  736 */       this.award_count = _o_.award_count;
/*  737 */       this.award_time_stamp = _o_.award_time_stamp;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  742 */       this.role_id = _o_.role_id;
/*  743 */       this.role_name = _o_.role_name;
/*  744 */       this.random_type_id = _o_.random_type_id;
/*  745 */       this.award_count = _o_.award_count;
/*  746 */       this.award_time_stamp = _o_.award_time_stamp;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  752 */       _os_.marshal(this.role_id);
/*  753 */       _os_.marshal(this.role_name, "UTF-16LE");
/*  754 */       _os_.marshal(this.random_type_id);
/*  755 */       _os_.marshal(this.award_count);
/*  756 */       _os_.marshal(this.award_time_stamp);
/*  757 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  763 */       this.role_id = _os_.unmarshal_long();
/*  764 */       this.role_name = _os_.unmarshal_String("UTF-16LE");
/*  765 */       this.random_type_id = _os_.unmarshal_int();
/*  766 */       this.award_count = _os_.unmarshal_long();
/*  767 */       this.award_time_stamp = _os_.unmarshal_long();
/*  768 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  774 */       int _size_ = 0;
/*  775 */       _size_ += CodedOutputStream.computeInt64Size(1, this.role_id);
/*      */       try
/*      */       {
/*  778 */         _size_ += CodedOutputStream.computeBytesSize(2, ByteString.copyFrom(this.role_name, "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/*  782 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*  784 */       _size_ += CodedOutputStream.computeInt32Size(3, this.random_type_id);
/*  785 */       _size_ += CodedOutputStream.computeInt64Size(4, this.award_count);
/*  786 */       _size_ += CodedOutputStream.computeInt64Size(5, this.award_time_stamp);
/*  787 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  795 */         _output_.writeInt64(1, this.role_id);
/*  796 */         _output_.writeBytes(2, ByteString.copyFrom(this.role_name, "UTF-16LE"));
/*  797 */         _output_.writeInt32(3, this.random_type_id);
/*  798 */         _output_.writeInt64(4, this.award_count);
/*  799 */         _output_.writeInt64(5, this.award_time_stamp);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  803 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  805 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  813 */         boolean done = false;
/*  814 */         while (!done)
/*      */         {
/*  816 */           int tag = _input_.readTag();
/*  817 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  821 */             done = true;
/*  822 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  826 */             this.role_id = _input_.readInt64();
/*  827 */             break;
/*      */           
/*      */ 
/*      */           case 18: 
/*  831 */             this.role_name = _input_.readBytes().toString("UTF-16LE");
/*  832 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  836 */             this.random_type_id = _input_.readInt32();
/*  837 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  841 */             this.award_count = _input_.readInt64();
/*  842 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  846 */             this.award_time_stamp = _input_.readInt64();
/*  847 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  851 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  853 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  862 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  866 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  868 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DrawCarnivalAwardWinnerInfo copy()
/*      */     {
/*  874 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DrawCarnivalAwardWinnerInfo toData()
/*      */     {
/*  880 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.DrawCarnivalAwardWinnerInfo toBean()
/*      */     {
/*  885 */       return new DrawCarnivalAwardWinnerInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DrawCarnivalAwardWinnerInfo toDataIf()
/*      */     {
/*  891 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.DrawCarnivalAwardWinnerInfo toBeanIf()
/*      */     {
/*  896 */       return new DrawCarnivalAwardWinnerInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  902 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  906 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  910 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  914 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  918 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  922 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  926 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRole_id()
/*      */     {
/*  933 */       return this.role_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getRole_name()
/*      */     {
/*  940 */       return this.role_name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getRole_nameOctets()
/*      */     {
/*  947 */       return Octets.wrap(getRole_name(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRandom_type_id()
/*      */     {
/*  954 */       return this.random_type_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAward_count()
/*      */     {
/*  961 */       return this.award_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAward_time_stamp()
/*      */     {
/*  968 */       return this.award_time_stamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRole_id(long _v_)
/*      */     {
/*  975 */       this.role_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRole_name(String _v_)
/*      */     {
/*  982 */       if (null == _v_)
/*  983 */         throw new NullPointerException();
/*  984 */       this.role_name = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRole_nameOctets(Octets _v_)
/*      */     {
/*  991 */       setRole_name(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRandom_type_id(int _v_)
/*      */     {
/*  998 */       this.random_type_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAward_count(long _v_)
/*      */     {
/* 1005 */       this.award_count = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAward_time_stamp(long _v_)
/*      */     {
/* 1012 */       this.award_time_stamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1018 */       if (!(_o1_ instanceof Data)) return false;
/* 1019 */       Data _o_ = (Data)_o1_;
/* 1020 */       if (this.role_id != _o_.role_id) return false;
/* 1021 */       if (!this.role_name.equals(_o_.role_name)) return false;
/* 1022 */       if (this.random_type_id != _o_.random_type_id) return false;
/* 1023 */       if (this.award_count != _o_.award_count) return false;
/* 1024 */       if (this.award_time_stamp != _o_.award_time_stamp) return false;
/* 1025 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1031 */       int _h_ = 0;
/* 1032 */       _h_ = (int)(_h_ + this.role_id);
/* 1033 */       _h_ += this.role_name.hashCode();
/* 1034 */       _h_ += this.random_type_id;
/* 1035 */       _h_ = (int)(_h_ + this.award_count);
/* 1036 */       _h_ = (int)(_h_ + this.award_time_stamp);
/* 1037 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1043 */       StringBuilder _sb_ = new StringBuilder();
/* 1044 */       _sb_.append("(");
/* 1045 */       _sb_.append(this.role_id);
/* 1046 */       _sb_.append(",");
/* 1047 */       _sb_.append("'").append(this.role_name).append("'");
/* 1048 */       _sb_.append(",");
/* 1049 */       _sb_.append(this.random_type_id);
/* 1050 */       _sb_.append(",");
/* 1051 */       _sb_.append(this.award_count);
/* 1052 */       _sb_.append(",");
/* 1053 */       _sb_.append(this.award_time_stamp);
/* 1054 */       _sb_.append(")");
/* 1055 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\DrawCarnivalAwardWinnerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */